package com.qgstudio.dao;

import com.qgstudio.po.Software;
import com.qgstudio.po.Version;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface VersionDao {
    @Insert("INSERT INTO t_version(software_id,versionInf,`desc`,url,release_date) VALUES(#{software_id},#{versionInf},#{desc},#{url},#{release_date})")
    public int save(Version version);
    @Update("UPDATE t_version SET versionInf=#{versionInf},`desc`=#{desc},url=#{url} WHERE version_id=#{version_id}")
    public int update(Version version);
    @Delete("DELETE FROM t_version WHERE version_id = #{version_id}")
    public int delete(int version_id);

    @Select("SELECT * FROM t_version WHERE version_id = #{version_id}")
    public Version getById(int version_id);

    @Select("SELECT * FROM t_version WHERE software_id = #{software_id} AND versionInf = #{versionInf}")
    public Version getByVersionInf(@Param("software_id") int software_id,@Param("versionInf") String versionInf);

    //获得某个软件的最新版本
    @Select("select * from t_version as a where not exists (select 1 from t_version as b where b.software_id=a.software_id and b.version_id>a.version_id) AND a.software_id=#{software_id}")
    public Version getLatest(int software_id);

    //获得某个软件的所有版本
    @Select("SELECT * FROM t_version WHERE software_id=#{software_id}")
    public List<Version> getAllBySoftware_id(int software_id);

    @Select("SELECT * FROM t_version")
    public List<Version> getAll();

}
