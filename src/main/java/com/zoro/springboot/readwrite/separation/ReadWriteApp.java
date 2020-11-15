package com.zoro.springboot.readwrite.separation;

import com.zoro.springboot.readwrite.separation.config.DbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:11
 * @desc
 */
@SpringBootApplication
public class ReadWriteApp {
    public static void main(String[] args) {
        SpringApplication.run(ReadWriteApp.class,args);
    }
}
