package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.SoftwareDao;
import com.qgstudio.dao.VersionDao;
import com.qgstudio.po.Notice;
import com.qgstudio.po.Software;
import com.qgstudio.po.Version;
import com.qgstudio.service.NoticeService;
import com.qgstudio.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    private SoftwareDao softwareDao;
    //仅使用一次，发布软件时同时发布第一个版本
    @Autowired
    private VersionDao versionDao;

    @Autowired
    private NoticeService noticeService;

    //发布软件时同时发布第一个版本
    @Override
    public Result add(Software software, Version version) throws IOException {
        //插入后自动赋值software_id
        ResultEnum result1 = softwareDao.save(software)==1 ? ResultEnum.SOFTWARE_SAVE_OK : ResultEnum.SOFTWARE_SAVE_ERR;
        version.setSoftware_id(software.getSoftware_id());
        ResultEnum result2 = versionDao.save(version)==1 ? ResultEnum.SOFTWARE_SAVE_OK : ResultEnum.SOFTWARE_SAVE_ERR;

        //发布软件后,进行消息通知
        noticeService.addNotice(version, "发布");

        return new Result(result1.getCode(),result1.getMsg()+"&"+result2.getMsg());
    }

    @Override
    public Result update(Software software) {
        ResultEnum result = softwareDao.update(software)==1 ? ResultEnum.SOFTWARE_UPDATE_OK : ResultEnum.SOFTWARE_UPDATE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result delete(Integer id) {
        ResultEnum result = softwareDao.delete(id)==1 ? ResultEnum.SOFTWARE_DELETE_OK : ResultEnum.SOFTWARE_DELETE_ERR;
        return new Result(result.getCode(),result.getMsg());
    }

    @Override
    public Result<Software> getById(Integer id) {
        Software software = softwareDao.getById(id);
        ResultEnum result = software!=null ? ResultEnum.SOFTWARE_GET_OK : ResultEnum.SOFTWARE_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),software);
    }


    @Override
    public Result<Software> getBySoftware_name(String software_name, boolean isVague) {
        if(isVague){
            //处理字符串,两侧加上%以进行模糊查询
            software_name = "%" + software_name +"%";
        }
        List<Software> softwareList = softwareDao.getBySoftware_name(software_name);
        ResultEnum result = !softwareList.isEmpty() ? ResultEnum.SOFTWARE_GET_OK : ResultEnum.SOFTWARE_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),softwareList);
    }

    @Override
    public Result<List> getByGroup(Integer group_id) {
        List<Software> softwareList = softwareDao.getByGroup(group_id);
        ResultEnum result = !softwareList.isEmpty() ? ResultEnum.SOFTWARE_GET_OK : ResultEnum.SOFTWARE_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),softwareList);
    }

    @Override
    public Result<List> getAll() {
        List<Software> softwareList = softwareDao.getAll();
        ResultEnum result = !softwareList.isEmpty() ? ResultEnum.SOFTWARE_GET_OK : ResultEnum.SOFTWARE_GET_ERR;
        return new Result(result.getCode(),result.getMsg(),softwareList);
    }
}
