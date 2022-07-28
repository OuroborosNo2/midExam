package com.qgstudio.dao;

import com.qgstudio.po.Code;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 授权码对象
 * @author YC104
 */
public interface CodeDao {


    /**
     * 新增授权码
//     * @param code :授权码对象
//     * @return :返回影响的行数
//     */
//    @Insert("insert into t_code (license_id, owner_name, mac, cpu,hard, code, user_id)" +
//            " values (#{license_id},#{owner_name},#{mac},#{cpu},#{hard},#{code},#{user_id})")
//    @Options(useGeneratedKeys = true,keyProperty = "code_id")
//    int save(Code code);
//
//
//    /**
//     * 通过用户id和许可证id获取下面授权码对象集合
//     * @param user_id :用户id
//     * @param license_id:许可证id
//     * @return :返回授权码集合对象
//     */
//    @Select("select * from t_code where  user_id = #{user_id} and license_id = #{license_id} ")
//    List<Code> getAllByLicenseIdAndUserId (@Param("user_id") int user_id, @Param("license_id") int license_id);
//
//
//    /**
//     * 当许可证升级后,授权码需要更新
//     * @param code :传进来的授权码对象
//     * @return :返回影响的行数
//     */
//    @Update("update t_code set code=#{code} where user_id = #{user_id} and license_id = #{license_id}  ")
//    int upgrade(Code code);
//
//    /**
//     * 查询一张许可证下有多少条授权码
//     * @param user_id :用户id
//     * @param license_id :许可证id
//     * @return :返回查询的条数
//     */
//    @Select("select count(*) from t_code where user_id = #{user_id} and license_id = #{license_id} ")
//    int getCount(@Param("user_id") int user_id,@Param("license_id") int license_id);
}
