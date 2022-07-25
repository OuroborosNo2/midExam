package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.NoticeDao;
import com.qgstudio.dao.SoftwareDao;
import com.qgstudio.dao.VersionDao;
import com.qgstudio.po.Notice;
import com.qgstudio.po.Software;
import com.qgstudio.po.Version;
import com.qgstudio.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description: 通知service的实现类
 * @author: stop.yc
 * @create: 2022-07-25 20:42
 **/

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private SoftwareDao softwareDao;

    @Autowired
    private VersionDao versionDao;

    @Override
    public Result<List<Notice>> getAllNotice() {
        List<Notice> notices = noticeDao.getAll();
        ResultEnum result = notices == null ? ResultEnum.USER_NOTICE_NONE : ResultEnum.USER_NOTICE_OK;
        return new Result<>(result.getCode(),result.getMsg(),notices);
    }

    @Override
    public Result<Notice> addNotice(Notice notice, Software software) {

        //1.一个通知的内容,需要包含,软件名,软件信息,软件版本信息,通知时间,还有点击后跳转到某个页面的地址.
        String content = "";

        //2.软件名称
        String softwareName = software.getSoftware_name();

        //3.若是发行新版本,需要软件描述,若是更新,则需要两者都要.
        String softwareDesc = software.getDesc();

        //获取软件对应版本的信息.
//        versionDao

        //4.拼接字符串,形成通知内容.


        //




        return null;
    }


}
