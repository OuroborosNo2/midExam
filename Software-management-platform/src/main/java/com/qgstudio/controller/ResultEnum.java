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
    SERVER_INTERNAL_ERROR(500,"服务器内部错误")

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
