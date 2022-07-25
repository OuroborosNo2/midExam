package com.qgstudio.dao;

import com.qgstudio.po.Software;
import com.qgstudio.po.Version;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VersionDao {
    @Insert("INSERT INTO T_VERSION VALUES(null,#{software_id},#{versionInf},#{desc},#{url})")
    public void save(Version version);
    @Update("UPDATE T_VERSION SET software=#{software_id},versionInf=#{versionInf},desc=#{desc},url=#{url}")
    public void update(Version version);
    @Delete("DELETE FROM T_VERSION WHERE version_id = #{version_id}")
    public int delete(int version_id);

    @Select("SELECT * FROM T_VERSION WHERE version_id = #{version_id}")
    public Version getById(int version_id);

    //获得某个软件的所有版本
    @Select("SELECT * FROM T_VERSION WHERE software_id=#{software_id}")
    public List<Version> getAllBySoftware_id(int software_id);

    @Select("SELECT * FROM T_VERSION")
    public List<Version> getAll();
}
