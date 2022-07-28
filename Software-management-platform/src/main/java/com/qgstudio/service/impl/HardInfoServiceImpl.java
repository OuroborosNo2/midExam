package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.dao.HardInfoDao;
import com.qgstudio.po.HardInfo;
import com.qgstudio.service.HardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Software-management-platform
 * @description: 硬件信息业务层接口实现类
 * @author: stop.yc
 * @create: 2022-07-28 13:24
 **/

@Service
public class HardInfoServiceImpl implements HardInfoService {

    @Autowired
    private HardInfoDao hardInfoDao;

    @Override
    public Result<HardInfo> saveHardInfo(HardInfo hardInfo) {
        //新增业务,

        return null;
    }

    @Override
    public Result<HardInfo> update(HardInfo hardInfo) {
        return null;
    }
}
