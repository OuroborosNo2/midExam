package com.qgstudio.po;

import org.springframework.stereotype.Component;

@Component
public class Software {
    private int software_id;//软件id
    private String desc;//软件描述
    private int group_id;//软件集群id（所属设计，开发等代表id）

    public Software(int software_id, String desc, int group_id) {
        this.software_id = software_id;
        this.desc = desc;
        this.group_id = group_id;
    }

    public Software() {
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
