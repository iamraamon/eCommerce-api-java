package com.shop.registration.controller;

import com.shop.registration.entity.TokenEntity;
import com.shop.registration.event.RegistrationCompleteEvent;
import com.shop.registration.model.PasswordModel;
import com.shop.registration.model.UserModel;
import com.shop.registration.service.TokenService;
import com.shop.user.entity.UserEntity;
import com.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
public class RegistrationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest httpServletRequest){

        UserEntity userEntity = tokenService.registerUser(userModel);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(
                userEntity,applicationUrl(httpServletRequest)
        ));
        return "success";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = tokenService.validateVerificationToken(token);

        if(result.equalsIgnoreCase("valid"))
        {
            return "User Verified Successfully";
        }
        return "Bad User";
    }

    @GetMapping("/resendVerifyRegistration")
    public String resendVerifyRegistration(@RequestParam("token") String oldToken,HttpServletRequest httpServletRequest){
        TokenEntity tokenEntity = tokenService.generateNewToken(oldToken);
        UserEntity userEntity = tokenEntity.getUserEntity();
        resendVerifyRegistrationMail(userEntity,applicationUrl(httpServletRequest),tokenEntity);
        return "Verificaton link sent";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordModel passwordModel,HttpServletRequest httpServletRequest){
        UserEntity userEntity = userService.findUserByEmail(passwordModel.getEmail());
        
        String url ="";

        if(userEntity!=null){
            String token = UUID.randomUUID().toString();
            tokenService.createPasswordResetTokenForUser(userEntity,token);
            url = passwordResetTokenMail(userEntity,applicationUrl(httpServletRequest),token);
        }
        return url;
    }

    @PostMapping("/savePassword")
    public String savePassword(@RequestParam("token") String token,@RequestBody PasswordModel passwordModel){
        String result = tokenService.validatePasswordResetToken(token);

        if(!result.equalsIgnoreCase("valid")) {
            return "invalid token";
        }
        Optional<UserEntity> userEntity = tokenService.getUserEntityByPassword(token);

        if(userEntity.isPresent()){
            tokenService.changePassword(userEntity.get(),passwordModel.getNewPassword());
            return "Password Reset Successfully";
        }else {
            return "Invalid Token";
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody PasswordModel passwordModel){
        UserEntity userEntity = userService.findUserByEmail(passwordModel.getEmail());
        if(!tokenService.checkIfValidOldPassword(userEntity,passwordModel.getOldPassword())){
            return "Invalid Old Password";
        }
        //save the password
        tokenService.changePassword(userEntity,passwordModel.getNewPassword());
        return "Password Changed Successfully";
    }

    private String passwordResetTokenMail(UserEntity userEntity, String applicationUrl, String token) {
        //send mail to user
        String url = applicationUrl + "/savePassword?token=" + token;

        //send verification url
        log.info("click the link to reset your password : {}",url);
        return url;
    }

    private void resendVerifyRegistrationMail(UserEntity userEntity, String applicationUrl,TokenEntity tokenEntity) {
        //send mail to user
        String url = applicationUrl + "/verifyRegistration?token=" + tokenEntity.getToken();

        //send verification url
        log.info("click the link to verify your account : {}",url);
    }

    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" +
                httpServletRequest.getServerName() +
                ":" +
                httpServletRequest.getServerPort() +
                httpServletRequest.getContextPath();
    }

}
