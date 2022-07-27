package com.qgstudio.dao;

import com.qgstudio.po.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-25 20:26
 **/
public interface NoticeDao {

    @Insert("insert into t_notice values (null,#{content},#{time},#{software_id})")
    @Options(useGeneratedKeys = true,keyProperty = "notice_id")
//    @SelectKey(keyProperty = "notice_id", resultType = int.class, before = false,
//            statement = "select LAST_INSERT_ID()"
//    )
    int save (Notice notice);


    @Select("select * from t_notice where notice_id in (select notice_id from t_notice_user where user_id = #{user_id})")
    List<Notice> getAll(int user_id);


    @Select("select * from t_notice where notice_id = #{notice_id}")
    Notice getNoticeById(int notice_id);




}
