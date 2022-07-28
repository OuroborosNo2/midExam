package com.qgstudio.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description: 用户绑定的通知持久层
 * @author: stop.yc
 * @create: 2022-07-27 11:45
 **/
public interface NoticeAndUserDao {
    /**
     * 为多位用户添加某条通知
     * @param notice_id 通知id
     * @param user_ids 用户id集
     * @return 0代表失败，1代表成功
     * */
    @Insert("<script> " +
            "insert into " + "t_notice_user" +
            " (" + "notice_id,user_id" + ") " +
            "values " +
            "<foreach collection='ids' index='index' item='item' separator=','> "
            +
            "(#{notice_id},#{item})"
            +
            "</foreach> " +
            "</script>")
    int addUserAndNotice (@Param("notice_id") int notice_id,@Param("ids") List<Integer> user_ids);

    /**
     * 为某位用户删除某条通知
     * @param notice_id 通知id
     * @param user_id 用户id
     * @return 0代表失败，1代表成功
     * */
    @Delete("delete from `t_notice_user` where notice_id = #{notice_id} and user_id = #{user_id}")
    int deleteById(@Param("notice_id") int notice_id,@Param("user_id") int user_id);

    /**
     * 为某位用户批量删除通知
     * @param notice_ids 通知id集
     * @param user_id 用户id
     * @return 0代表失败，1代表成功
     * */
    @Delete("<script> "+
            "delete from t_notice_user where notice_id in "+
            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>#{item}</foreach> and user_id = #{user_id} "+
            "</script>")
    int deleteByIds(@Param("ids") List<Integer> notice_ids,@Param("user_id") int user_id);
}
