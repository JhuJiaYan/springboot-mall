package com.yan.springbootmall.service.Impl;

import com.yan.springbootmall.dao.UserDao;
import com.yan.springbootmall.dto.UserRegisterRequest;
import com.yan.springbootmall.model.User;
import com.yan.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
