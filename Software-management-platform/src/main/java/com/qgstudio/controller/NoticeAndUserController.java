package com.qgstudio.controller;

import com.qgstudio.po.Notice;
import com.qgstudio.service.NoticeAndUserService;
import com.qgstudio.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-26 22:55
 **/

@RestController
@RequestMapping(value = "/delNotices", produces = "application/json;charset=UTF-8")
public class NoticeAndUserController {

    @Autowired
    private NoticeAndUserService noticeAndUserService;

    @DeleteMapping("/ids")
    public Result<Object> deleteByIds(@RequestBody Map<Integer,List<Integer>> ids_userId) {
        Set<Integer> integers = ids_userId.keySet();

        int key = 0;
        List<Integer> ids = null;

        for (Integer integer : integers) {
            key = integer;
            ids = ids_userId.get(integer);
        }

        return noticeAndUserService.deleteByIds(ids,key);

    }

    @DeleteMapping("/id")
    public Result<Object> deleteById(@RequestBody Map<Integer, Integer> notice_idAndUser_id) {

        Set<Integer> integers = notice_idAndUser_id.keySet();
        Integer key = 0;
        Integer value = 0;
        for (Integer integer : integers) {
            key = integer;
            value = notice_idAndUser_id.get(integer);
        }
        return noticeAndUserService.deleteById(key,value);

    }
}
