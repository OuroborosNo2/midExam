package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.User;

import java.security.NoSuchAlgorithmException;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-25 09:35
 **/

public interface UserService {
    /**
     * 用户登录功能
     * @param user :登录的用户封装对象
     * @return :返回用户结果集
     */
    Result<User> login(User user) throws NoSuchAlgorithmException;
}