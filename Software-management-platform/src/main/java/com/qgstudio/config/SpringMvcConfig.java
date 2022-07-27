package com.qgstudio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
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
@PropertySource("classpath:file.properties")
@EnableWebMvc
public class SpringMvcConfig {

    @Value("${file.maxUploadSizePerFile}")
    private long maxUploadSizePerFile;

    @Value("${file.maxUploadSize}")
    private long maxUploadSizeFile;

    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        cmr.setMaxUploadSizePerFile(maxUploadSizePerFile);
        cmr.setMaxUploadSize(maxUploadSizeFile);
        return cmr;
    }
}
