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

        //2.数据查询,是否查得到
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

    @Override
    public Result register(User user) {
        ResultEnum result = userDao.save(user)==1 ? ResultEnum.USER_SAVE_OK : ResultEnum.USER_SAVE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result update(User user) {
        ResultEnum result = userDao.update(user)==1 ? ResultEnum.USER_UPDATE_OK : ResultEnum.USER_UPDATE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result delete(Integer id) {
        ResultEnum result = userDao.delete(id)==1 ? ResultEnum.USER_DELETE_OK : ResultEnum.USER_DELETE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result<User> getById(Integer id) {
        User user = userDao.getById(id);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }
    @Override
    public Result<User> getByUsername(String username) {
        User user = userDao.getByUsername(username);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }

    @Override
    public Result<User> getByPhone_number(String phone_number) {
        User user = userDao.getByPhone_number(phone_number);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }

    @Override
    public Result<User> getByEmail(String email) {
        User user = userDao.getByEmail(email);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }

    @Override
    public Result<List> getAll() {
        List<User> userList = userDao.getAll();
        ResultEnum result = !userList.isEmpty() ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),userList);
    }








}
