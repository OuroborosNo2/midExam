package com.qgstudio.controller;



import com.qgstudio.po.User;
import com.qgstudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
//2.定义controller
//2.1 使用@Controller定义bean

@RestController
@RequestMapping(value = "/users",produces = "application/json;charset=UTF-8")

public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public Result<User> login(@RequestBody User user) throws NoSuchAlgorithmException {
        return userService.login(user);
    }
}
