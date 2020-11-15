package com.zoro.springboot.readwrite.separation.datasource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:18
 * @desc
 */
@Slf4j
public class DbThreadLocal {
    public static final String WRITE = "write";
    public static final String READ = "read";

    private static ThreadLocal<String> contextHolder= new ThreadLocal<>();

    public static void setDbType(String dbType) {
        if (dbType == null) {
            log.info("dbType为空");
            throw new NullPointerException();
        }
        log.info("设置 ThreadLocal>>>>>>{} , 设置dbType为：{}",Thread.currentThread().getId() , dbType);
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return contextHolder.get() == null ? WRITE : contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
        log.info("清理 ThreadLocal>>>>>>{}",Thread.currentThread().getId());
    }
}
