package com.qgstudio.service;

import com.qgstudio.controller.Result;

import java.util.List;
/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-27 09:35
 **/
public interface NoticeAndUserService {

     /**
      *
      * @param notice_id
      * @param ids
      * @return
      */
     int bind (int notice_id, List<Integer> ids);

     /**
      *
      * @param notice_id 通知id
      * @param user_id 用户id
      * @return 结果集
      */
     Result<Object> deleteById (int notice_id, int user_id);

     /**
      *
      * @param notice_id 通知id
      * @param user_id 用户id
      * @return 结果集
      */
     Result<Object> deleteByIds(List<Integer> notice_id, int user_id);
}
