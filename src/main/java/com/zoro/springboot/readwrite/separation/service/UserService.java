package com.zoro.springboot.readwrite.separation.service;


import com.zoro.springboot.readwrite.separation.model.UserInfo;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:56
 * @desc
 */
public interface UserService {
    UserInfo getUserByName(String userName);
    void insert(String userName);
    void insertSlave(String userName);
}
