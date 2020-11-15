package com.zoro.springboot.readwrite.separation.mapper;

import com.zoro.springboot.readwrite.separation.datasource.Read;
import com.zoro.springboot.readwrite.separation.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:18
 * @desc
 */
@Repository
public interface UserMapper {
    @Select("select id,user_name userName from userinfo where user_name = #{userName} limit 1")
    @Read
    UserInfo getUserByName(String userName);

    @Insert("insert into userinfo(user_name) values(#{userName})")
    void insert(String userName);

    @Insert("insert into userinfo(user_name) values(#{userName})")
    @Read
    void insertSlave(String userName);
}
