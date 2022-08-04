package com.shop.registration.event;

import com.shop.user.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{

    private UserEntity userEntity;
    private String applicationUrl;

    public RegistrationCompleteEvent(UserEntity userEntity,String applicationUrl){
        super(userEntity);
        this.userEntity = userEntity;
        this.applicationUrl = applicationUrl;
    }
}
