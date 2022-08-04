package com.shop.user.repository;

import com.shop.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findByFirstNameIgnoreCase(String firstName);

    List<UserEntity> findByFirstNameContainingIgnoreCase(String firstName);

    UserEntity findByMobile(String number);


    UserEntity findByEmail(String email);
}
