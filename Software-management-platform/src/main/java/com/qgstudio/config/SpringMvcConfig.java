package com.qgstudio.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
//3. 创建springmvc的配置文件,加载controller对应的bean
@Configuration
@ComponentScan({"com.qgstudio.controller","com.qgstudio.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
