package com.qgstudio.controller.interceptor;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @program: Software-management-platform
 * @description:拦截器1
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
@Component
public class ProjectInterceptor implements HandlerInterceptor {

    @Override
    /**原始方法调用前执行的内容*/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入controller前拦截下来进行session验证登录,权限验证则做在切面
        if((request.getRequestURI().equals("/users")&&request.getMethod().equals("POST"))
        || request.getRequestURI().equals("/users/register")){
            //登录和注册这两个请求不用验证session
        }else{
            if (request.getSession().getAttribute("user") == null) {
                response.setCharacterEncoding("UTF-8");
                //只好手写Result json了
                response.setContentType("application/json");
                PrintWriter writer = response.getWriter();
                String result = "{\"code\": %d, \"msg\": \"%s\", \"data\": null}";
                writer.write(String.format(result,ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMsg()));
                return false;
            }
        }
        return true;
    }

    @Override
    /**原始方法调用后执行的内容*/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle...");
    }

    @Override
    /**原始方法调用完成后执行的内容*/
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion...");
    }
}
