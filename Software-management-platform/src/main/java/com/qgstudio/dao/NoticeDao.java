package com.qgstudio.dao;

import com.qgstudio.po.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description: 通知模块持久层
 * @author: stop.yc
 * @create: 2022-07-25 20:26
 **/
public interface NoticeDao {

    /**
     * 插入通知数据,@Options注释使数据插入成功后将自增的id主键赋值给该通知对象
     * @param notice 通知对象
     * @return 0代表失败，1代表成功
     * */
    @Insert("insert into t_notice values (null,#{content},#{time},#{software_id})")
    @Options(useGeneratedKeys = true,keyProperty = "notice_id")/*@SelectKey(keyProperty = "notice_id", resultType = int.class, before = false,
            statement = "select LAST_INSERT_ID()"
    )*/
    int save (Notice notice);

    /**
     * 查询某用户的所有通知
     * @param user_id 用户id
     * @return 返回查询到的通知集
     * */
    @Select("select * from t_notice where notice_id in (select notice_id from t_notice_user where user_id = #{user_id})")
    List<Notice> getAll(int user_id);

    /**
     * 通过id查询某条通知
     * @param notice_id 通知id
     * @return 返回查询到的通知对象
     * */
    @Select("select * from t_notice where notice_id = #{notice_id}")
    Notice getNoticeById(int notice_id);




}
