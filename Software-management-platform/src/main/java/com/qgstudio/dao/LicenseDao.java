package com.qgstudio.dao;

import com.qgstudio.po.License;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-27 11:45
 **/
public interface LicenseDao {

    /**
     * 插入一条许可证数据
     * @param license 许可证对象
     * @return 0代表失败，1代表成功
     * */
    @Insert("insert into t_license (user_id, software_id, function_type, version_id, owner_name, mac, cpu, hard, begin_date, end_date, validity_time, code)" +
            " values (#{user_id},#{software_id},#{function_type},#{version_id},#{owner_name},#{mac},#{cpu},#{hard},#{begin_date},#{end_date},#{validity_time},#{code})")
    @Options(useGeneratedKeys = true,keyProperty = "code_id")
    int save(License license);

    /**
     * 通过软件id查询某用户的所有许可证
     * @param user_id 用户id
     * @param software_id 软件id
     * @return 0代表失败，1代表成功
     * */
    @Select("select * from t_license where user_id = #{user_id} and software_id = #{software_id}")
    List<License> getAllBySoftwareId (int user_id,int software_id);

    /**
     * 修改
     * @param license 许可证对象
     * @return 0代表失败，1代表成功
     * */
    @Update("update t_license set mac=#{mac},cpu=#{cpu},hard=#{hard},code=#{code},owner_name=#{owner_name} where software_id=#{software_id} and user_id=#{user_id} ")
    int updateInfo(License license);

    /**
     * 修改
     * @param license 许可证对象
     * @return 0代表失败，1代表成功
     * */
    @Update("update t_license set function_type=#{function_type},version_id=#{version_id},code=#{code},begin_date=#{begin_date},end_date=#{end_date},validity_time=#{validity_time} where software_id=#{software_id} and user_id=#{user_id}")
    int upgrade(License license);

    /**
     * 查询
     * @param license 许可证对象
     * @return 0代表失败，1代表成功
     * */
    @Select("select count(*) from t_license where software_id = #{software_id} and user_id=#{user_id}")
    int getCount(License license);


}
