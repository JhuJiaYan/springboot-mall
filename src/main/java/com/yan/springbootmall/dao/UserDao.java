package com.yan.springbootmall.dao;

import com.yan.springbootmall.dto.UserRegisterRequest;
import com.yan.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
