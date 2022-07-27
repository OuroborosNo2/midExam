package com.qgstudio.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeAndUserDao {



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




    @Delete("delete from `t_notice_user` where notice_id = #{notice_id} and user_id = #{user_id}")
    int deleteById(@Param("notice_id") int notice_id,@Param("user_id") int user_id);


    @Delete("<script> "+
            "delete from t_notice_user where notice_id in "+
            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>#{item}</foreach> and user_id = #{user_id} "+
            "</script>")
    int deleteByIds(@Param("ids") List<Integer> notice_ids,@Param("user_id") int user_id);
}
