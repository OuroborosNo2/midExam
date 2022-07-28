package com.qgstudio.service;


import com.qgstudio.controller.Result;
import com.qgstudio.po.HardInfo;

/**
 * 硬件信息业务层接口
 * @author YC104
 */
public interface HardInfoService {

    /**
     * 新增硬件信息
     * @param hardInfo :硬件信息
     * @return :返回封装了硬件信息的结果
     */
    Result<HardInfo> saveHardInfo(HardInfo hardInfo);
    Result<HardInfo> update(HardInfo hardInfo);
}
