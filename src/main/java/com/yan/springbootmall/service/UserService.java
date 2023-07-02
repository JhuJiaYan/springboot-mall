package com.yan.springbootmall.service;

import com.yan.springbootmall.dto.UserLoginRequest;
import com.yan.springbootmall.dto.UserRegisterRequest;
import com.yan.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
