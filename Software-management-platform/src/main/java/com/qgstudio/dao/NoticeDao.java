package com.qgstudio.dao;

import com.qgstudio.po.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-25 20:26
 **/
public interface NoticeDao {

    @Insert("insert into t_notice values (null,#{content},#{time},#{software_id},#{url}))")
    int save (Notice notice);

    @Select("select * from t_notice")
    List<Notice> getAll();
}
