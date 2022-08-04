package com.shop.registration.listener;

import com.shop.registration.event.RegistrationCompleteEvent;
import com.shop.registration.service.TokenService;
import com.shop.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private TokenService tokenService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        //create verification token for user with link
        UserEntity userEntity = event.getUserEntity();
        String token = UUID.randomUUID().toString();
        tokenService.saveVerificationTokenForUser(token,userEntity);

        //send mail to user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        //send verification url
        log.info("click the link to verify your account : {}",url);
    }
}
