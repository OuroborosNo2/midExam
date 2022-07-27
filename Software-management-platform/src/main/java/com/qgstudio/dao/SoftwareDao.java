package com.qgstudio.dao;

import com.qgstudio.po.Software;
import com.qgstudio.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface SoftwareDao {
    @Insert("INSERT INTO T_SOFTWARE(software_name,`desc`,group_id) VALUES(#{software_name},#{desc},#{group_id})")
    @Options(useGeneratedKeys = true,keyProperty = "software_id",keyColumn = "software_id")
    public int save(Software software);
    @Update("UPDATE T_SOFTWARE SET software_name=#{software_name},`desc`=#{desc},group_id=#{group_id} WHERE software_id=#{software_id}")
    public int update(Software software);
    @Delete("DELETE FROM T_SOFTWARE WHERE software_id = #{software_id}")
    public int delete(int software_id);

    @Select("SELECT * FROM T_SOFTWARE WHERE software_id = #{software_id}")
    public Software getById(int software_id);

    @Select("SELECT * FROM T_SOFTWARE WHERE software_name LIKE #{software_name}")
    public List<Software> getBySoftware_name(String software_name);

    @Select("SELECT * FROM T_SOFTWARE WHERE group_id = #{group_id}")
    public List<Software> getByGroup(int group_id);
    @Select("SELECT * FROM T_SOFTWARE")
    public List<Software> getAll();

}
