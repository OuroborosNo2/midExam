package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.UserDao;
import com.qgstudio.po.User;
import com.qgstudio.service.UserService;
import com.qgstudio.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @program: Software-management-platform
 * @description: UserService实现类
 * @author: stop.yc
 * @create: 2022-07-25 09:35
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {


    //自动装配
    @Autowired
    private UserDao userDao;

    @Override
    public Result<User> login(User user) throws NoSuchAlgorithmException {

        //1.调用userDao获取用户对象
        System.out.println(user);
        User userByUsername = userDao.getByUsername(user.getUsername());
        System.out.println(user.getUsername());
        System.out.println(userByUsername);

//        //2.数据查询,是否查得到
        if (userByUsername == null) {
            //2.1 空
            return new Result<>(ResultEnum.USERNAME_ERROR.getCode(),ResultEnum.USERNAME_ERROR.getMsg(),null);
        }else {
            //2.2不为空,检查密码
            if (userByUsername.getPassword().equals(Md5Utils.getMD5(user.getPassword()))) {
                userByUsername.setPassword("");
                return new Result<>(200,"登录成功",userByUsername);
            } else {
                return new Result<>(ResultEnum.PASSWORD_ERROR.getCode(),ResultEnum.PASSWORD_ERROR.getMsg(),null);
            }
        }
    }
}
