package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.*;
import com.qgstudio.po.Notice;
import com.qgstudio.po.Software;
import com.qgstudio.po.Version;
import com.qgstudio.service.NoticeService;
import com.qgstudio.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Autowired
    private UserDao userDao;

    @Autowired
    private NoticeAndUserDao noticeAndUserDao;

    @Override
    public Result<List<Notice>> getAllNotice(int user_id) {
        List<Notice> notices = noticeDao.getAll(user_id);
        ResultEnum result = notices == null ? ResultEnum.USER_NOTICE_NONE : ResultEnum.USER_NOTICE_OK;
        return new Result<>(result.getCode(),result.getMsg(),notices);
    }

    @Override
    public Result<Notice> addNotice(Version version,String updateOrReleaseStr) throws IOException {

        //1.一个通知的内容,需要包含,软件名,软件信息,软件版本信息,通知时间
        StringBuilder content = new StringBuilder("");

        //2.通过版本信息获取软件信息
        Software software = softwareDao.getById(version.getSoftware_id());

        //3.需要软件描述,和版本信息
        String desc = software.getDesc();
        String software_name = software.getSoftware_name();
        String versionDesc = version.getDesc();
        String versionInf = version.getVersionInf();

        //4.获取网络时间
        Date websiteDatetime = TimeUtils.getWebsiteDatetime();

        //5.拼接字符串,形成通知内容.
        content.append(software_name).append(updateOrReleaseStr).append(versionInf).append(",").append(versionDesc).append("点击跳转~");

        System.out.println(content);
        System.out.println(websiteDatetime);

        //6.调用dao,新增notice,
        Notice notice1 = new Notice(content.toString(), websiteDatetime, software.getSoftware_id());
        int save = noticeDao.save(notice1);

        ResultEnum result = save != 0 ? ResultEnum.SUCCESS : ResultEnum.SERVER_INTERNAL_ERROR;
        Notice notice = noticeDao.getNoticeById(notice1.getNotice_id());

        //7.新增了一条notice后,需要给全部人都发一条消息一个是离线消息,一个在线消息.

        //7.1离线消息.
        //首先获取全部的用户id
        List<Integer> allId = userDao.getAllId();
        int i = noticeAndUserDao.addUserAndNotice(notice1.getNotice_id(), allId);

        result = i != 0 ? ResultEnum.SUCCESS : ResultEnum.SERVER_INTERNAL_ERROR;
        return new Result<>(result.getCode(),result.getMsg(),notice);
    }


}
