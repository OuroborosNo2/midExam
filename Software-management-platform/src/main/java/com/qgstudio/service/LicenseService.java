package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.po.License;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-27 09:35
 **/
public interface LicenseService {

    /**
     * 添加硬件指纹信息
     * @param license 许可证对象
     * @return 结果集
     * @throws Exception
     */
    Result<License> save(License license) throws Exception;




}
