package com.qgstudio.dao;

import com.qgstudio.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Insert("INSERT INTO t_user(username,password,phone_number,email,permission) VALUES(#{username},#{password},#{phone_number},#{email},0)")
    public int save(User user);
    @Update("UPDATE t_user SET username=#{username},phone_number=#{phone_number},email=#{email} WHERE user_id=#{user_id}")
    public int update(User user);
    @Update("UPDATE t_user SET password=#{newPwd} WHERE user_id=#{user_id}")
    public int updatePassword(@Param("user_id") int user_id,@Param("newPwd") String newPwd);
    @Delete("DELETE FROM t_user WHERE user_id = #{user_id}")
    public int delete(int user_id);

    //设置权限
    @Update("UPDATE t_user SET permission=#{permission} WHERE user_id=#{user_id}")
    public int changePermission(@Param("user_id") int user_id, @Param("permission")int permission);

    @Select("SELECT * FROM t_user WHERE user_id = #{user_id}")
    public User getById(int user_id);
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    public User getByUsername(String username);
    @Select("SELECT * FROM t_user WHERE phone_number = #{phone_number}")
    public User getByPhone_number(String phone_number);
    @Select("SELECT * FROM t_user WHERE email = #{email}")
    public User getByEmail(String email);

    @Select("SELECT * FROM t_user")
    public List<User> getAll();

    @Select("SELECT `user_id` FROM t_user")
    public List<Integer> getAllId();
}
