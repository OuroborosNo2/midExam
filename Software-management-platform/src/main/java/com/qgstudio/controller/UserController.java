package com.qgstudio.controller;



import com.qgstudio.dao.SoftwareDao;
import com.qgstudio.dao.UserDao;
import com.qgstudio.po.User;
import com.qgstudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
//2.定义controller
//2.1 使用@Controller定义bean

@RestController
@RequestMapping(value = "user",produces = "application/json;charset=UTF-8")

public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public Result register(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/username")
    public Result getByUsername(String username) {
        return service.getByUsername(username);
    }

    @GetMapping("/phone_number")
    public Result getByPhone_number(String phone_number) {
        return service.getByPhone_number(phone_number);
    }

    @GetMapping("/email")
    public Result getByEmail(String email) {
        return service.getByEmail(email);
    }

    @GetMapping
    public Result getAll() {
        return service.getAll();
    }


}
