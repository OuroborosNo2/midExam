package com.qgstudio.controller;

import com.qgstudio.po.Notice;
import com.qgstudio.po.Version;
import com.qgstudio.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @program: Software-management-platform
 * @description: 通知Controller
 * @author: stop.yc
 * @create: 2022-07-25 21:46
 **/
@RestController
@RequestMapping(value = "/notices",produces = "application/json;charset=UTF-8")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    Result<List<Notice>> getAll() {
        int user_id = 1;
        return noticeService.getAllNotice(user_id);
    }


    @PostMapping
    Result<Notice> addNotice() throws IOException {
        Version version = new Version(1, 1, "1.0.0.1", "发布了全新版本", "asdffd");
        return noticeService.addNotice(version,"发布");
    }
}
