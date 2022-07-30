package com.qgstudio.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qgstudio.exception.BusinessException;
import com.qgstudio.po.User;
import com.qgstudio.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @program: Software-management-platform
 * @description: 用户模块表现层
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
@RestController
@RequestMapping(value = "/users",produces = "application/json;charset=UTF-8")

public class UserController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    private UserService userService;

    @PostMapping
    public Result<User> login(@RequestBody User user) throws BusinessException,NoSuchAlgorithmException{
        return userService.login(user);
    }
    @GetMapping("/logout")
    public Result<User> logout(){
        //销毁会话
        request.getSession().invalidate();
        return new Result(ResultEnum.USER_LOGOUT_OK.getCode(),ResultEnum.USER_LOGOUT_OK.getMsg());
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) throws BusinessException,NoSuchAlgorithmException{
        return userService.register(user);
    }

    @PutMapping
    public Result update(@RequestBody User user) throws BusinessException,NoSuchAlgorithmException{
        return userService.update(user);
    }

    @PostMapping("/updatePwd")
    public Result updatePassword(@RequestBody Map<String,String> map) throws BusinessException,NoSuchAlgorithmException{
        return userService.updatePassword(Integer.valueOf(map.get("user_id")),map.get("oldPwd"),map.get("newPwd"));
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
