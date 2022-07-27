package com.qgstudio.service;

import com.qgstudio.controller.Result;

import java.util.List;

public interface NoticeAndUserService {

     int bind (int notice_id, List<Integer> ids);

     Result<Object> deleteById (int notice_id, int user_id);

     Result<Object> deleteByIds(List<Integer> notice_id, int user_id);
}
