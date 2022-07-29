package com.qgstudio.service.impl;

import com.qgstudio.controller.Result;
import com.qgstudio.controller.ResultEnum;
import com.qgstudio.dao.CodeDao;
import com.qgstudio.dao.HardInfoDao;
import com.qgstudio.dao.LicenseDao;
import com.qgstudio.po.CodedText;
import com.qgstudio.po.HardInfo;
import com.qgstudio.po.License;
import com.qgstudio.service.CheckCodeTxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: Software-management-platform
 * @description: 验证授权码的接口实现类
 * @author: stop.yc
 * @create: 2022-07-29 16:44
 **/

@Service("checkService")
@Transactional
public class CheckCodeTxtServiceImpl implements CheckCodeTxtService {


    @Autowired
    private LicenseDao licenseDao;

    @Autowired
    private HardInfoDao hardInfoDao;

    @Autowired
    private CodeDao codeDao;
    @Override
    public Result<Boolean> checkCodeTxt(CodedText codedText) {
        System.out.println(codedText);
        //拿到为这种软件开了许可证的许可证id集合
        List<License> licenses = licenseDao.getBySoftIdAndFunctionTypeAndVersionId(codedText.getSoftware_id(),codedText.getFunction_type(),codedText.getVersion_id());
        if (licenses.isEmpty()) {
            return new Result<>(ResultEnum.VERIFY_ERR.getCode(),ResultEnum.VERIFY_ERR.getMsg(),false);
        }

        //这些许可证对应了多个的硬件信息id
        List<Integer> infoIds = codeDao.getInfoIdByLicenseId(licenses);
        if (infoIds.isEmpty()) {
            return new Result<>(ResultEnum.VERIFY_ERR.getCode(),ResultEnum.VERIFY_ERR.getMsg(),false);
        }


        //这些硬件信息id对应了一个硬件指纹
        List<HardInfo> codes = hardInfoDao.getByInfoIds(infoIds);
        if (codes.isEmpty()) {
            return new Result<>(ResultEnum.VERIFY_ERR.getCode(),ResultEnum.VERIFY_ERR.getMsg(),false);
        }

        StringBuilder sb = new StringBuilder("");

        //对硬件指纹进行遍历
        for (HardInfo code : codes) {
            sb.append(code.getCpu() + code.getHard());
            //cpu和硬盘信息相同
            System.out.println("客户端硬件信息: "+sb.toString());
            System.out.println("服务端硬件信息: " + codedText.getCpu()+codedText.getHard());
            if (sb.toString().equals(codedText.getCpu()+codedText.getHard())) {
                System.out.println("cpu和硬盘正确");
                //现在判断mac地址
                System.out.println("服务端 mac" + code.getMac());

                System.out.println("客户端 mac " + codedText.getMacs());
                if (codedText.getMacs().contains(code.getMac())) {
                    //来到这里表示硬件指纹是对应上了,现在判断是否过期
                    System.out.println("硬件指纹匹配成功");
                    int info_id = code.getInfo_id();
                    int user_id = code.getUser_id();
                    List<Integer> licenseIds = codeDao.getLicenseIdsByUserIdAndInfoId(user_id,info_id);
                    if (licenseIds.isEmpty()) {
                        return new Result<>(ResultEnum.VERIFY_ERR.getCode(),ResultEnum.VERIFY_ERR.getMsg(),false);
                    }
                    Date end_date = licenseDao.getEndTimeByLicenseIdsAndUidAndSidAndFidAndVid(licenseIds,user_id,codedText.getSoftware_id(),codedText.getFunction_type(),codedText.getVersion_id());
                    if (end_date.getTime() - codedText.getNow().getTime() > 0) {
                        return new Result<>(ResultEnum.VERIFY_OK.getCode(),ResultEnum.VERIFY_OK.getMsg(),true);
                    }
                }
            }
        }
        return new Result<>(ResultEnum.VERIFY_ERR.getCode(),ResultEnum.VERIFY_ERR.getMsg(),false);
    }
}
