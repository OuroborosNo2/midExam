package com.qgstudio.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @program: Software-management-platform
 * @description:定义一个servlet容器启动的配置类,在里面加载spring的配置
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
public class SpringContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**加载Spring配置类*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    /**加载SpringMVC配置类*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    /**设置SpringMVC请求地址拦截规则*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    /**设置servlet拦截器，进行修改字符编码等操作*/
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }


}