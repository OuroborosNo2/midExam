package com.qgstudio.service.impl;

import com.qgstudio.constant.regex;
import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.UserDao;
import com.qgstudio.exception.BusinessException;
import com.qgstudio.po.User;
import com.qgstudio.service.UserService;
import com.qgstudio.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

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
    /**
     * 用户dao实现类
     */
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
            return new Result<>(ResultEnum.USER_USERNAME_ERROR.getCode(),ResultEnum.USER_USERNAME_ERROR.getMsg(),null);
        }else {
            //2.2不为空,检查密码
            if (userByUsername.getPassword().equals(Md5Utils.getMD5(user.getPassword()))) {
                userByUsername.setPassword("");
                return new Result<>(ResultEnum.USER_LOGIN_OK.getCode(),ResultEnum.USER_LOGIN_OK.getMsg(),userByUsername);
            } else {
                return new Result<>(ResultEnum.USER_PWD_ERROR.getCode(),ResultEnum.USER_PWD_ERROR.getMsg(),null);
            }
        }
    }

    @Override
    public Result<User> register(User user) throws NoSuchAlgorithmException {
        //1.注册用户,用户会输入用户名,密码,手机号,邮箱,首先先判断用户名,手机,邮箱是否重复,
        User userByName = userDao.getByUsername(user.getUsername());
        User userByPhone = userDao.getByPhone_number(user.getPhone_number());
        User userByEmail = userDao.getByEmail(user.getEmail());

        //1.1用户名重复
        if (userByName != null) {
            return new Result<>(ResultEnum.USER_SAVE_NAME_ERR.getCode(),ResultEnum.USER_SAVE_NAME_ERR.getMsg(),null);
        }
        //1.2 手机号已经被注册
        if (userByPhone != null) {
            return new Result<>(ResultEnum.USER_SAVE_PHONE_ERR.getCode(),ResultEnum.USER_SAVE_PHONE_ERR.getMsg(),null);
        }
        //1.3 邮箱已经被注册
        if (userByEmail != null) {
            return new Result<>(ResultEnum.USER_SAVE_EMAIL_ERR.getCode(),ResultEnum.USER_SAVE_EMAIL_ERR.getMsg(),null);
        }

        //2.首先先判断密码是否合法
        if (!Pattern.matches(regex.REGEX_PWD, user.getPassword())) {
            throw new BusinessException(ResultEnum.EX_PWD.getCode(),ResultEnum.EX_PWD.getMsg());
        }

        //3.到这里表示可以注册,记住密码需要加密
        user.setPassword(Md5Utils.getMD5(user.getPassword()));

        ResultEnum result = userDao.save(user) == 1 ? ResultEnum.USER_SAVE_OK : ResultEnum.SERVER_INTERNAL_ERROR;

        return new Result<>(result.getCode(),result.getMsg());
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
    public Result getById(Integer id) {
        User user = userDao.getById(id);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }
    @Override
    public Result getByUsername(String username) {
        User user = userDao.getByUsername(username);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }

    @Override
    public Result getByPhone_number(String phone_number) {
        User user = userDao.getByPhone_number(phone_number);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }

    @Override
    public Result getByEmail(String email) {
        User user = userDao.getByEmail(email);
        ResultEnum result = user!=null ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),user);
    }

    @Override
    public Result getAll() {
        List<User> userList = userDao.getAll();
        ResultEnum result = !userList.isEmpty() ? ResultEnum.USER_GET_OK : ResultEnum.USER_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),userList);
    }

}
