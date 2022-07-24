package com.qgstudio.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
//2.定义controller
//2.1 使用@Controller定义bean

@RestController
@RequestMapping(value = "",produces = "text/json;charset=UTF-8")

public class UserController {

    @GetMapping("/test")
    public String test() {
        return "接通成功";
    }
}
