package com.qgstudio.controller;



import com.qgstudio.exception.BusinessException;
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
    public Result<User> login(@RequestBody User user) throws BusinessException,NoSuchAlgorithmException{
        return userService.login(user);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) throws BusinessException,NoSuchAlgorithmException{
        return userService.register(user);
    }

    @PutMapping
    public Result update(@RequestBody User user) throws BusinessException,NoSuchAlgorithmException{
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/username")
    public Result getByUsername(String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/phone_number")
    public Result getByPhone_number(String phone_number) {
        return userService.getByPhone_number(phone_number);
    }

    @GetMapping("/email")
    public Result getByEmail(String email) {
        return userService.getByEmail(email);
    }

    @GetMapping
    public Result getAll() {
        return userService.getAll();
    }

    @PutMapping("/change")
    public Result changePermission(Integer id,Integer permission){
        return userService.changePermission(id,permission);
    }

}
