package com.qgstudio.po;


import com.qgstudio.constant.regex;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class User {
    private int user_id;//用户id
    private String username;//用户名
    private String password;//密码

    public String getPhone_number() {
        return phone_number;
    }

    private String phone_number;//手机号码
    private String email;//邮箱
    private int permission;//权限，0为普通用户，1为管理员


    public User(int user_id, String username, String password, String phone_number, String email, int permission) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.permission = permission;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {

        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!Pattern.matches(regex.REGEX_NAME, username)) {
            System.out.println(username);
            System.out.println("不匹配" + !Pattern.matches(regex.REGEX_NAME, username));
            throw new BusinessException(ResultEnum.EX_NAME.getCode(),ResultEnum.EX_NAME.getMsg());
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Pattern.matches(regex.REGEX_EMAIL, email)) {
            throw new BusinessException(ResultEnum.EX_EMAIL.getCode(),ResultEnum.EX_EMAIL.getMsg());
        }
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        if (!Pattern.matches(regex.REGEX_PHONE, phone_number)) {
            throw new BusinessException(ResultEnum.EX_PHONE.getCode(),ResultEnum.EX_PHONE.getMsg());
        }
        this.phone_number = phone_number;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
