package com.shop.user.service;

import com.shop.user.entity.UserEntity;
import com.shop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }

    @Transactional
    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository .deleteById(id);
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public List<UserEntity> getUserByName(String firstName){
        return userRepository.findByFirstNameIgnoreCase(firstName);
    }

    public List<UserEntity> getUserBySpellings(String firstName){
        return userRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public UserEntity getUserByMobile(String number){
        return userRepository.findByMobile(number);
    }


    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
