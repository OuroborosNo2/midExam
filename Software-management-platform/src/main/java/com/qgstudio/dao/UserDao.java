package com.qgstudio.dao;

import com.qgstudio.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Insert("INSERT INTO T_USER(username,password,phone_number,email,permission) VALUES(#{username},#{password},#{phone_number},#{email},0)")
    public int save(User user);
    @Update("UPDATE T_USER SET username=#{username},password=#{password},phone_number=#{phone_number},email=#{email} WHERE user_id=#{user_id}")
    public int update(User user);
    @Delete("DELETE FROM T_USER WHERE user_id = #{user_id}")
    public int delete(int user_id);

    //设置权限
    @Update("UPDATE T_USER SET permission=#{permission} WHERE user_id=#{user_id}")
    public int changePermission(@Param("user_id") int user_id, @Param("permission")int permission);

    @Select("SELECT * FROM T_USER WHERE user_id = #{user_id}")
    public User getById(int user_id);
    @Select("SELECT * FROM T_USER WHERE username = #{username}")
    public User getByUsername(String username);
    @Select("SELECT * FROM T_USER WHERE phone_number = #{phone_number}")
    public User getByPhone_number(String phone_number);
    @Select("SELECT * FROM T_USER WHERE email = #{email}")
    public User getByEmail(String email);

    @Select("SELECT * FROM T_USER")
    public List<User> getAll();

    @Select("SELECT `user_id` FROM T_USER")
    public List<Integer> getAllId();

}
