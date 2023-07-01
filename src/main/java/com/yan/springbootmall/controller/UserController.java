package com.yan.springbootmall.controller;

import com.yan.springbootmall.dto.UserRegisterRequest;
import com.yan.springbootmall.model.User;
import com.yan.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //用戶註冊
    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {

        Integer userId = userService.register(userRegisterRequest);//註冊
        User user=userService.getUserById(userId);//查詢User
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
