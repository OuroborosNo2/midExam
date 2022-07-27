package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.NoticeAndUserDao;
import com.qgstudio.service.NoticeAndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-26 20:26
 **/

@Service
@Transactional
public class NoticeAndUserServiceImpl implements NoticeAndUserService {


    @Autowired
    private NoticeAndUserDao noticeAndUserDao;
    @Override
    public int bind(int notice_id, List<Integer> ids) {
        return noticeAndUserDao.addUserAndNotice(notice_id,ids);
    }

    @Override
    public Result<Object> deleteById(int notice_id, int user_id) {

        //未进行非0判断

        int i = noticeAndUserDao.deleteById(notice_id, user_id);

        ResultEnum resultEnum = i != 0 ? ResultEnum.USER_DEL_NOTICE_OK : ResultEnum.USER_DEL_NOTICE_ERR;

        return new Result<>(resultEnum.getCode(),resultEnum.getMsg());
    }

    @Override
    public Result<Object> deleteByIds(List<Integer> notice_id, int user_id) {

        int i = noticeAndUserDao.deleteByIds(notice_id, user_id);

        ResultEnum resultEnum = i != 0 ? ResultEnum.USER_DEL_NOTICE_OK : ResultEnum.USER_DEL_NOTICE_ERR;

        return new Result<>(resultEnum.getCode(),resultEnum.getMsg());
    }
}
