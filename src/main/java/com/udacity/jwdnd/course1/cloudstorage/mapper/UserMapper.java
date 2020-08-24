package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    @Update("UPDATE USERS " + "SET username = #{username}, firstname = #{firstname}, lastname = #{lastname}, password = #{password}" + "WHERE userId = #{userId}")
    User updateUser(User user);

    @Delete("DELETE FROM USERS WHERE userId = #{userId}")
    void delete(Integer userId);
}
