package com.shop.user.controller;

import com.shop.user.entity.UserEntity;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getUserList(){
        return userService.getUser();
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return userService.saveUser(userEntity);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity userEntity){
        return userService.saveUser(userEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "Deleted successfully";
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public List<UserEntity> getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/spelling/{name}")
    public List<UserEntity> getUserByNameSpelling(@PathVariable String name){
        return userService.getUserBySpellings(name);
    }

    @GetMapping("/mobile/{number}")
    public UserEntity getUserByMobile(@PathVariable String number){
        return userService.getUserByMobile(number);
    }
}
