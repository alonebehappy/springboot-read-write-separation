package com.zoro.springboot.readwrite.separation.service.impl;

import com.zoro.springboot.readwrite.separation.mapper.UserMapper;
import com.zoro.springboot.readwrite.separation.model.UserInfo;
import com.zoro.springboot.readwrite.separation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:18
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper ;

    @Override
    public UserInfo getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public void insert(String userName) {
        userMapper.insert(userName);
    }

    @Override
    public void insertSlave(String userName) {
        userMapper.insertSlave(userName);
    }
}
