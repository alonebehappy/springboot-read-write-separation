package com.zoro.springboot.readwrite.separation.service;

import com.zoro.springboot.readwrite.separation.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 22:05
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    UserService userService ;

    @Autowired
    CommonService commonService;
    @Test
    public void getUserByName() {
        System.out.println(userService.getUserByName("zoro"));
    }

    @Test
    public void insert() {
        userService.insert("aaa");
    }

    @Test
    public void commTest(){
        UserInfo userInfo = commonService.commTest();
        log.info("{}",userInfo);

    }
    @Test
    public void commTransactionTest(){
        UserInfo userInfo = commonService.commTransactionTest();
        log.info("{}",userInfo);

    }
}