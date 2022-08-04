package com.shop.registration.repository;

import com.shop.registration.entity.PasswordResetTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetTokenEntity,Long> {
    PasswordResetTokenEntity findByToken(String token);
}
