package com.qgstudio.controller;

/**
 * @program Software-management-platform
* @Description: 结果集枚举
* @Param:
* @return:
* @Author: stop.yc
* @Date: 2022-07-24 19:10
*/
public enum ResultEnum {
    //自定义
    //通用
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    RESOURCE_NOT_FOUND(404,"资源未找到"),
    PARAMETER_NOT_VALID(400,"参数不合法"),
    SERVER_INTERNAL_ERROR(500,"服务器正在忙碌中,请稍后试试吧"),



    //异常
    EX_EMAIL(00000,"邮箱格式错误"),
    EX_NAME(11111,"用户名需6-12位"),
    EX_PWD(22222,"密码需6-20位数字加大小写字母"),
    EX_PHONE(33333,"手机格式错误"),


    //我们的结果码为这个结构,A0XYZ
    //A代表一个大的模块,0是补位,后期依据需要更改,X代表一个功能(如注册),Y代表一个情况(如用户名重复),Z为1代表成功,0代表失败,
    //用户模块 60XYZ,
    //600Y0 用户-登录-情况-失败
    USER_USERNAME_ERROR(60010, "用户名错误"),
    USER_PWD_ERROR(60020, "密码错误"),

    //600Y1 用户-登录-情况-成功
    USER_LOGIN_OK(60000,"登录成功"),

    //601Y1 用户-注册-情况-成功
    USER_SAVE_OK(60101,"注册用户成功"),
    USER_UPDATE_OK(60111,"修改用户成功"),
    USER_DELETE_OK(60121,"删除用户成功"),
    USER_GET_OK(60131,"查询用户成功"),

    //601Y0 用户-注册-情况-失败
    USER_SAVE_NAME_ERR(60130,"用户名已经重复"),
    USER_SAVE_PHONE_ERR(60140,"手机号已经被注册"),
    USER_SAVE_EMAIL_ERR(60150,"邮箱已经被注册"),
    USER_UPDATE_ERR(60140,"修改用户失败"),
    USER_DELETE_ERR(60150,"删除用户失败"),
    USER_GET_ERR(60160,"查询用户失败"),

    //软件模块 70XYZ,
    SOFTWARE_SAVE_OK(70031,"添加软件成功"),
    SOFTWARE_UPDATE_OK(70041,"修改软件成功"),
    SOFTWARE_DELETE_OK(70051,"删除软件成功"),
    SOFTWARE_GET_OK(70061,"查询软件成功"),

    SOFTWARE_SAVE_ERR(70030,"添加软件失败"),
    SOFTWARE_UPDATE_ERR(70040,"修改软件失败"),
    SOFTWARE_DELETE_ERR(70050,"删除软件失败"),
    SOFTWARE_GET_ERR(70060,"查询软件失败"),

    //版本模块
    VERSION_SAVE_OK(80031,"添加版本成功"),
    VERSION_UPDATE_OK(80041,"修改版本成功"),
    VERSION_DELETE_OK(80051,"删除版本成功"),
    VERSION_GET_OK(80061,"查询版本成功"),

    VERSION_SAVE_ERR(80030,"添加版本失败"),
    VERSION_UPDATE_ERR(80040,"修改版本失败"),
    VERSION_DELETE_ERR(80050,"删除版本失败"),
    VERSION_GET_ERR(80060,"查询版本失败")

    ;
    /**
     * 编号
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
