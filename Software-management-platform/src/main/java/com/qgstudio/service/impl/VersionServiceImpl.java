package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.SoftwareDao;
import com.qgstudio.dao.VersionDao;
import com.qgstudio.po.Version;
import com.qgstudio.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionDao versionDao;

    @Override
    public Result add(Version version) {
        ResultEnum result = versionDao.save(version)==1 ? ResultEnum.VERSION_SAVE_OK : ResultEnum.VERSION_SAVE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result update(Version version) {
        ResultEnum result = versionDao.update(version)==1 ? ResultEnum.VERSION_UPDATE_OK : ResultEnum.VERSION_UPDATE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result delete(Integer id) {
        ResultEnum result = versionDao.delete(id)==1 ? ResultEnum.VERSION_DELETE_OK : ResultEnum.VERSION_DELETE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result<Version> getById(Integer id) {
        Version version = versionDao.getById(id);
        ResultEnum result = version!=null ? ResultEnum.VERSION_GET_OK : ResultEnum.VERSION_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),version);
    }

    @Override
    public Result<Version> getLatestBySoftware_id(Integer software_id) {
        Version version = versionDao.getLatest(software_id);
        ResultEnum result = version!=null ? ResultEnum.VERSION_GET_OK : ResultEnum.VERSION_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),version);
    }

    @Override
    public Result<List> getAllBySoftware_id(Integer software_id) {
        List<Version> versionList = versionDao.getAllBySoftware_id(software_id);
        ResultEnum result = !versionList.isEmpty() ? ResultEnum.VERSION_GET_OK : ResultEnum.VERSION_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),versionList);
    }

    @Override
    public Result<List> getAll() {
        List<Version> versionList = versionDao.getAll();
        ResultEnum result = !versionList.isEmpty() ? ResultEnum.VERSION_GET_OK : ResultEnum.VERSION_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),versionList);
    }
}
