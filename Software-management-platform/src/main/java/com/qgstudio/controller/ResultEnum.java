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

    //602Y1 用户-通知-情况-成功
    USER_NOTICE_NONE(60211,"当前无通知"),
    USER_NOTICE_OK(60221,"获取通知成功"),
    USER_DEL_NOTICE_OK(60231,"删除通知成功"),

    //602Y0 用户-通知-情况-失败
    USER_DEL_NOTICE_ERR(60230,"删除通知失败"),




    //产品模块 70XXY,
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
