package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.Notice;
import com.qgstudio.po.Software;
import com.qgstudio.po.Version;

import java.io.IOException;
import java.util.List;

public interface NoticeService {


    /**
     * 获取所有的通知信息
     * @return :返回一个通知集合的结果集
     */
    Result<List<Notice>> getAllNotice (int user_id);

    /**
     * 当发行软件或者更新版本时发送通知
     * @param version :版本信息(第一代或者最新)
     * @param updateOrReleaseStr (是更新的还是发行的,选择,更新或者发行(自定义))
     * @return :返回通知类结果集
     */
    Result<Notice> addNotice (Version version,String updateOrReleaseStr) throws IOException;
}
