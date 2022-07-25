package com.qgstudio.dao;

import com.qgstudio.po.Software;
import com.qgstudio.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SoftwareDao {
    @Insert("INSERT INTO T_SOFTWARE VALUES(null,#{desc},#{group_id})")
    public void save(Software software);
    @Update("UPDATE T_SOFTWARE SET desc=#{desc},group_id=#{group_id}")
    public void update(Software software);
    @Delete("DELETE FROM T_SOFTWARE WHERE software_id = #{software_id}")
    public int delete(int software_id);

    @Select("SELECT * FROM T_SOFTWARE WHERE software_id = #{software_id}")
    public Software getById(int software_id);

    @Select("SELECT * FROM T_SOFTWARE WHERE group_id = #{group_id}")
    public Software getGroup(int group_id);
    @Select("SELECT * FROM T_SOFTWARE")
    public List<Software> getAll();
}
