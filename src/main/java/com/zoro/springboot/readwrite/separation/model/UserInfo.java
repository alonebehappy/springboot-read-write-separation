package com.zoro.springboot.readwrite.separation.model;

import java.io.Serializable;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:18
 * @desc
 */
public class UserInfo implements Serializable {
    private int id ;

    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
