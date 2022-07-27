package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.po.License;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface LicenseService {

    /**
     *添加硬件指纹信息
     */
    Result<License> save(License license) throws Exception;




}
