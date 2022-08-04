package com.shop.registration.entity;

import com.shop.user.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class TokenEntity {

    private static final int EXPIRATION_TIME = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Date expiredtime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_token_id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_VERIFY"))
    private UserEntity userEntity;

    public TokenEntity(UserEntity userEntity,String token){
        super();
        this.userEntity = userEntity;
        this.token = token;
        this.expiredtime = calculateExpiredDate(EXPIRATION_TIME);
    }

    public TokenEntity(String token){
        super();
        this.token = token;
        this.expiredtime = calculateExpiredDate(EXPIRATION_TIME);
    }

    private Date calculateExpiredDate(int expirationTime) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
