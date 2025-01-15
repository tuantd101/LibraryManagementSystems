package com.prm392.library.bean;

import java.util.Date;

public class LogShow {
    private Long uuid;

    private int number;
    private String action_name;
    private Date created_at;
    private Long created_by;
    private String old;
    private String news;

    public LogShow(Long uuid, int number, String action_name, Date created_at, Long created_by, String old, String news) {
        this.uuid = uuid;
        this.number = number;
        this.action_name = action_name;
        this.created_at = created_at;
        this.created_by = created_by;
        this.old = old;
        this.news = news;
    }

    public LogShow() {
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Long created_by) {
        this.created_by = created_by;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
