package com.qgstudio.po;

import java.time.LocalDateTime;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-25 20:08
 **/
public class Notice {

    /**
     * 通知id
     */
    private int notice_id;


    /**
     * 内容
     */
    private String content;


    /**
     * 通知时间
     */
    private LocalDateTime time;


    /**
     * 软件id
     */
    private int software_id;

    /**
     * 网站详情地址
     */
    private String url;

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", software_id=" + software_id +
                ", url='" + url + '\'' +
                '}';
    }

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Notice() {
    }

    public Notice(int notice_id, String content, LocalDateTime time, int software_id, String url) {
        this.notice_id = notice_id;
        this.content = content;
        this.time = time;
        this.software_id = software_id;
        this.url = url;
    }
}
