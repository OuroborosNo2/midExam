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


    //用户模块
    USERNAME_ERROR(60010,"用户名错误"),
    PASSWORD_ERROR(60020,"密码错误"),

    USER_SAVE_OK(60031,"注册用户成功"),
    USER_UPDATE_OK(60041,"修改用户成功"),
    USER_DELETE_OK(60051,"删除用户成功"),
    USER_GET_OK(60061,"查询用户成功"),
    /*USER_GET_BY_PHONE_NUMBER_OK(60061,"查询用户成功"),
    USER_GET_BY_EMAIL_OK(60071,"查询用户成功"),
    USER_GET_BY_ID_OK(60081,"查询用户成功"),
    USER_GET_ALL_OK(60091,"查询用户成功"),*/

    USER_SAVE_ERR(60030,"注册用户失败"),
    USER_UPDATE_ERR(60040,"修改用户失败"),
    USER_DELETE_ERR(60050,"删除用户失败"),
    USER_GET_ERR(60060,"查询用户失败")
    /*USER_GET_BY_PHONE_NUMBER_ERR(60060,"查询用户失败"),
    USER_GET_BY_EMAIL_ERR(60070,"查询用户失败"),
    USER_GET_BY_ID_ERR(60080,"查询用户失败"),
    USER_GET_ALL_ERR(60090,"查询用户失败"),*/
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
