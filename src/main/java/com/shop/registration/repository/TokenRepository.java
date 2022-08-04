package com.shop.registration.repository;

import com.shop.registration.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity,Long> {
    TokenEntity findByToken(String token);
}
