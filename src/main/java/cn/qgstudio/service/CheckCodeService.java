package cn.qgstudio.service;

import cn.qgstudio.constant.SystemConstant;
import cn.qgstudio.po.CodedText;
import cn.qgstudio.util.Declassify;
import cn.qgstudio.util.HardWareUtils;
import cn.qgstudio.view.Main;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @program: ClientDemo
 * @description:
 * @author: stop.yc
 * @create: 2022-07-31 23:50
 **/
public class CheckCodeService {
    public boolean checkCode(String code) throws Exception {

        //获得解密密钥
        String check = null;
        try {
            check = Declassify.check(code);
        } catch (Exception e) {
            System.out.println("密钥输入错误");
            e.printStackTrace();
            return false;
        }

        //获得用户信息
        CodedText codedText = JSON.parseObject(check, CodedText.class);

        int software_id = codedText.getSoftware_id();
        int function_type = codedText.getFunction_type();
        int version_id = codedText.getVersion_id();
        String cpu = codedText.getCpu().substring(100);
        String hard = codedText.getHard();
        List<String> macs = codedText.getMacs();
        Date now = codedText.getNow();

        if (software_id != Main.software_id) {
            System.out.println("软件id错误");
            return false;
        }

        if (function_type != Main.function_type) {
            System.out.println("类别错误");
            return false;
        }

        if (version_id != Main.version_id) {
            System.out.println("版本错误");
            return false;
        }

        if (!HardWareUtils.getHardDiskSN("wmic CPU get ProcessorID").contains(cpu)) {
            System.out.println("cpu错误");
            return false;
        }

        if (!HardWareUtils.getHardDiskSN("wmic diskdrive get serialnumber").contains(hard)) {
            System.out.println("硬盘错误");
            return false;
        }

        if (!HardWareUtils.getMacAddresses().contains(macs.get(0))) {
            System.out.println("mac错误");
            return false;
        }

        if (now.getTime() < System.currentTimeMillis()) {
            System.out.println("过期了");
            return false;
        }


        return true;


    }
}
