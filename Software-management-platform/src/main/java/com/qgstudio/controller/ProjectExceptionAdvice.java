package com.qgstudio.controller;

import com.qgstudio.exception.BusinessException;
import com.qgstudio.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.Executors;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        System.out.println(ex.getMessage());
        return new Result(ex.getCode(),ex.getMessage(),null);
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        System.out.println(ex.getMessage());
        return new Result(ex.getCode(),ex.getMessage(),null);
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        System.out.println(ex.getMessage());
        return new Result(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg(),null);
    }
}
