package com.zoro.springboot.readwrite.separation.service;

import com.zoro.springboot.readwrite.separation.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 22:45
 * @desc
 */
@Service
public class CommonService {
    @Autowired
    UserService userService;

    @Transactional(rollbackFor = Exception.class)
    public UserInfo commTest(){
        userService.insert("XXX");
        UserInfo zoro = userService.getUserByName("zoro");
        return zoro;

    }

    @Transactional(rollbackFor = Exception.class)
    public UserInfo commTransactionTest(){
        userService.insert("XXXX");
        UserInfo zoro = userService.getUserByName("zoro");
        userService.insertSlave("XXXX");
        if (zoro != null) {
            throw  new RuntimeException("测试事务回滚");
        }
        return zoro;

    }
}
