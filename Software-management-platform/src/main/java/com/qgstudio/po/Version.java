package com.qgstudio.po;

import org.springframework.stereotype.Component;

@Component
public class Version {
    private int version_id;//版本id
    private int software_id;//对应的软件id
    private String versionInf;//版本信息（1.0.0.1）
    private String desc;//版本更新描述
    private String url;//下载地址

    public Version(int version_id, int software_id, String versionInf, String desc, String url) {
        this.version_id = version_id;
        this.software_id = software_id;
        this.versionInf = versionInf;
        this.desc = desc;
        this.url = url;
    }

    public Version() {
    }

    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public String getVersionInf() {
        return versionInf;
    }

    public void setVersionInf(String versionInf) {
        this.versionInf = versionInf;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
