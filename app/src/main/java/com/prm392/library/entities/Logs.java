package com.prm392.library.entities;

import java.util.Date;
import java.util.Date;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Logs")
public class Logs {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uuid")
    private Long uuid;

    @ColumnInfo(name = "action_name")
    private String action_name;

    @ColumnInfo(name = "created_at")
    private Date created_at;

    @ColumnInfo(name = "created_by")
    private Long created_by;

    @ColumnInfo(name = "updated_at")
    private Date updated_at;

    @ColumnInfo(name = "updated_by")
    private Long updated_by;

    @ColumnInfo(name = "deleted_at")
    private Date deleted_at;

    @ColumnInfo(name = "deleted_by")
    private Long deleted_by;

    @ColumnInfo(name = "old")
    private String old;

    @ColumnInfo(name = "news")
    private String news;


    public Logs(Long uuid, String action_name, Date created_at, Long created_by, Date updated_at, Long updated_by,
                Date deleted_at, Long deleted_by, String old, String news) {
        this.uuid = uuid;
        this.action_name = action_name;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
        this.old = old;
        this.news = news;
    }

    public Logs() {
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
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

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Long getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Long updated_by) {
        this.updated_by = updated_by;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Long getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(Long deleted_by) {
        this.deleted_by = deleted_by;
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

    @Override
    public String toString() {
        return "Logs{" +
                "uuid=" + uuid +
                ", action_name='" + action_name + '\'' +
                ", created_at=" + created_at +
                ", created_by=" + created_by +
                ", updated_at=" + updated_at +
                ", updated_by=" + updated_by +
                ", deleted_at=" + deleted_at +
                ", deleted_by=" + deleted_by +
                ", old='" + old + '\'' +
                ", news='" + news + '\'' +
                '}';
    }
}