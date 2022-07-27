package com.qgstudio.po;

import java.util.Date;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-27 11:37
 **/
public class License {
    private int code_id;
    private int user_id;
    private int software_id;
    private int function_type;
    private int version_id;
    private String owner_name;
    private String mac;
    private String cpu;
    private String hard;
    private Date begin_date;
    private Date end_date;
    private int validity_time;
    private String code;

    public int getCode_id() {
        return code_id;
    }

    public void setCode_id(int code_id) {
        this.code_id = code_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public int getFunction_type() {
        return function_type;
    }

    public void setFunction_type(int function_type) {
        this.function_type = function_type;
    }

    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHard() {
        return hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getValidity_time() {
        return validity_time;
    }

    public void setValidity_time(int validity_time) {
        this.validity_time = validity_time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public License() {
    }

    @Override
    public String toString() {
        return "License{" +
                "code_id=" + code_id +
                ", user_id=" + user_id +
                ", software_id=" + software_id +
                ", function_type=" + function_type +
                ", version_id=" + version_id +
                ", owner_name='" + owner_name + '\'' +
                ", mac='" + mac + '\'' +
                ", cpu='" + cpu + '\'' +
                ", hard='" + hard + '\'' +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                ", validity_time=" + validity_time +
                ", code='" + code + '\'' +
                '}';
    }

    public License(int code_id, int user_id, int software_id, int function_type, int version_id, String owner_name, String mac, String cpu, String hard, Date begin_date, Date end_date, int validity_time, String code) {
        this.code_id = code_id;
        this.user_id = user_id;
        this.software_id = software_id;
        this.function_type = function_type;
        this.version_id = version_id;
        this.owner_name = owner_name;
        this.mac = mac;
        this.cpu = cpu;
        this.hard = hard;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.validity_time = validity_time;
        this.code = code;
    }
}
