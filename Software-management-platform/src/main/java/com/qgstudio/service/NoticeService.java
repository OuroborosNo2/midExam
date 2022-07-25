package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.Notice;
import com.qgstudio.po.Software;

import java.util.List;

public interface NoticeService {


    /**
     * 获取所有的通知信息
     * @return :返回一个通知集合的结果集
     */
    Result<List<Notice>> getAllNotice ();


    /**
     * 新增通知
     * @param notice :新增的通知
     * @return :返回封装了通知的结果集
     */
    Result<Notice> addNotice (Notice notice, Software software);
}
