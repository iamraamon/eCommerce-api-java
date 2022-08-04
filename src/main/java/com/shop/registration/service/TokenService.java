package com.shop.registration.service;

import com.shop.registration.entity.PasswordResetTokenEntity;
import com.shop.registration.entity.TokenEntity;
import com.shop.registration.model.UserModel;
import com.shop.registration.repository.PasswordResetTokenRepository;
import com.shop.registration.repository.TokenRepository;
import com.shop.user.entity.UserEntity;
import com.shop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public UserEntity registerUser(UserModel userModel){

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userModel.getEmail());
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userModel.getLastName());
        userEntity.setMobile(userModel.getMobile());
        userEntity.setPasswordHash(passwordEncoder.encode(userModel.getPasswordHash()));
        userEntity.setAdmin(userModel.getAdmin());
        userEntity.setVendor(userModel.getVendor());

        SimpleDateFormat format = new SimpleDateFormat();
        Date date = new Date();
        userEntity.setRegisteredAt(format.format(date));

        userRepository.save(userEntity);
        return userEntity;
    }

    public void saveVerificationTokenForUser(String token, UserEntity userEntity) {

        TokenEntity tokenEntity = new TokenEntity(userEntity,token);
        tokenRepository.save(tokenEntity);
    }

    public String validateVerificationToken(String token) {
        TokenEntity tokenEntity = tokenRepository.findByToken(token);

        if(tokenEntity == null)
        {
            return "Invalid Token";
        }
        UserEntity userEntity = tokenEntity.getUserEntity();
        Calendar calendar = Calendar.getInstance();

        if((tokenEntity.getExpiredtime().getTime() - calendar.getTime().getTime()) <= 0)
        {
            tokenRepository.delete(tokenEntity);
            return "expired";
        }

        userEntity.setEnabled(true);
        userRepository.save(userEntity);
        return "valid";
    }

    public TokenEntity generateNewToken(String oldToken) {

        TokenEntity tokenEntity = tokenRepository.findByToken(oldToken);
        tokenEntity.setToken(UUID.randomUUID().toString());
        tokenRepository.save(tokenEntity);
        return tokenEntity;
    }

    public void createPasswordResetTokenForUser(UserEntity userEntity, String token) {
        PasswordResetTokenEntity passwordResetTokenEntity = new PasswordResetTokenEntity(userEntity,token);
        passwordResetTokenRepository.save(passwordResetTokenEntity);
    }

    public String validatePasswordResetToken(String token) {
        PasswordResetTokenEntity passwordResetTokenEntity = passwordResetTokenRepository.findByToken(token);

        if(passwordResetTokenEntity == null)
        {
            return "Invalid Token";
        }
        UserEntity userEntity = passwordResetTokenEntity.getUserEntity();
        Calendar calendar = Calendar.getInstance();

        if((passwordResetTokenEntity.getExpiredtime().getTime() - calendar.getTime().getTime()) <= 0)
        {
            passwordResetTokenRepository.delete(passwordResetTokenEntity);
            return "expired";
        }
        return "valid";
    }

    public Optional<UserEntity> getUserEntityByPassword(String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUserEntity());
    }

    public void changePassword(UserEntity userEntity, String newPassword) {
        userEntity.setPasswordHash(passwordEncoder.encode(newPassword));
        userRepository.save(userEntity);
    }

    public boolean checkIfValidOldPassword(UserEntity userEntity, String oldPassword) {
        return passwordEncoder.matches(oldPassword, userEntity.getPasswordHash());
    }
}
