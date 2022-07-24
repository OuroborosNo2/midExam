package com.qgstudio.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-24 19:10
 **/
public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){

        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();

        //设置模型类的别名扫描
        ssfb.setTypeAliasesPackage("com.qgstudio.po");

//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setLogImpl(Log4jImpl.class);

        //设置数据源
        ssfb.setDataSource(dataSource);

        return ssfb;
    }


    //定义bean，返回MapperScannerConfigurer对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.qgstudio.dao");
        return msc;
    }
}
