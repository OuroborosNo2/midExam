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
    SERVER_INTERNAL_ERROR(500,"服务器内部错误"),



    //用户模块 60XYZ, Z为1代表成功,0代表失败,XY代表方法
    //失败
    USERNAME_ERROR(60010, "用户名错误"),
    PASSWORD_ERROR(60020, "密码错误"),

    USER_SAVE_OK(60031,"注册用户成功"),
    USER_UPDATE_OK(60041,"修改用户成功"),
    USER_DELETE_OK(60051,"删除用户成功"),
    USER_GET_OK(60061,"查询用户成功"),


    USER_SAVE_ERR(60030,"注册用户失败"),
    USER_UPDATE_ERR(60040,"修改用户失败"),
    USER_DELETE_ERR(60050,"删除用户失败"),
    USER_GET_ERR(60060,"查询用户失败"),

    //软件模块 70XXY
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
