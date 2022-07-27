package com.qgstudio.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qgstudio.constant.SystemConstant;
import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.LicenseDao;
import com.qgstudio.po.License;
import com.qgstudio.service.LicenseService;
import com.qgstudio.util.AesUtil;
import com.qgstudio.util.RSAUtil;
import com.qgstudio.util.StringUtil;
import com.qgstudio.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.SliderUI;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-27 13:31
 **/
@Service
@Transactional
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    private LicenseDao licenseDao;

    @Override
    public Result<License> save(License license) throws Exception {
        //每个人每个软件只能有5个设备能进行使用.
        int count = licenseDao.getCount(license);
        if (count >= SystemConstant.MAX_NUM_LICENSE) {
            return new Result<>(ResultEnum.USER_HARD_SAVE_COUNT_ERR.getCode(),ResultEnum.USER_HARD_SAVE_COUNT_ERR.getMsg());
        }

        //需要生成现在日期
        Date begin_time = TimeUtils.getWebsiteDatetime();
        license.setBegin_date(begin_time);

        //调用java8新日期获取localDateTime
        LocalDateTime localDateTime = TimeUtils.dateToLocalDateTime(begin_time);

        //增加有效期,获取截止时间
        localDateTime = localDateTime.plusMonths(license.getValidity_time());

        //转换为date日期
        Date end_time = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        license.setEnd_date(end_time);

        System.out.println(license);


        //通过加密,生成code,
        String jsonString = JSONObject.toJSONString(license);

        System.out.println(jsonString);



        String  code = "";

        //1.获取aes密钥
        String aesKey = AesUtil.getAESKey(128,null);

        System.out.println(aesKey.length());

        //2.对数据进行aes加密
        String encrypt = AesUtil.encrypt(jsonString, aesKey);

        System.out.println(encrypt.length());

        //3.获取加密后密文长度
        String enDataLength = Integer.toHexString(encrypt.length());
        System.out.println(enDataLength);

        //4.进行rsa签名
        String sign = RSAUtil.sign(encrypt, RSAUtil.getPrivateKey(SystemConstant.PRIVATE_KEY));

        //5.拼接生成字符串

        code = aesKey + enDataLength + encrypt + sign;

        System.out.println("许可证为:"+code);
        license.setCode(code);

        check(code);
        ResultEnum result = licenseDao.save(license) == 1 ? ResultEnum.USER_LICENSE_SAVE_OK : ResultEnum.USER_LICENSE_SAVE_ERR;
        return new Result(result.getCode(),result.getMsg(),license);
    }


    public static int check(String lic) throws Exception {


        String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwMGl48mquEjgZRen2Wi0BejRgp0qVhY0YwKHwjcTN4TMprdAK0jABI+Rl1ckHPwX4rkwx03e3NLhAKis/uqEpsw9/YMkOut8qWRQkh9KAzAos5dN1DGgM2XXm1EluJKB/AvwBdgrHgxuuG+uhKbi2arh3/OY4oxqtfPkkvhRexwIDAQAB";
        //激活

        if (StringUtil.isEmpty(lic)) {
            return -1;
        }
        //1.把code前24位拆出来
        String aesKey = lic.substring(0, 24);

        //2.解析长度
        int encDataLength = Integer.parseInt(lic.substring(24,27),16);

        //3.把密文截取出来
        String encData = lic.substring(27, 27 + encDataLength);

        //4.截取签名信息
        String sign = lic.substring(27 + encDataLength);

        //5.校验
        boolean verify = RSAUtil.verify(encData, RSAUtil.getPublicKey(PUBLIC_KEY), sign);

        System.out.println("校验结果:  "+verify);

        if (!verify) {
            return -1;
        }
        String decrypt = AesUtil.decrypt(encData, aesKey);
        System.out.println(decrypt);

        License license = JSON.parseObject(decrypt, License.class);
        System.out.println(license);
        return 1;
    }
}
