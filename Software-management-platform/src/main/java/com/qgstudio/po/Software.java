package com.qgstudio.po;

import org.springframework.stereotype.Component;

@Component
public class Software {
    //软件id
    private int software_id;
    //软件描述
    private String desc;

    //软件集群id（所属设计，开发等代表id）
    private int group_id;
    //软件名称
    private String software_name;




    public Software() {
    }


    public Software(int software_id, String desc, int group_id, String software_name) {
        this.software_id = software_id;
        this.desc = desc;
        this.group_id = group_id;
        this.software_name = software_name;

    }

    public String getSoftware_name() {
        return software_name;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
