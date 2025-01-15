package com.prm392.library.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;
import java.util.Date;

@Entity(tableName = "Order")
public class Order {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uuid")
    private Long uuid;

    @ColumnInfo(name = "customer_id")
    private Long customer_id;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "borrowed_day")
    private Date borrowed_day;

    @ColumnInfo(name = "due_date")
    private Date due_date;

    @ColumnInfo(name = "return_date")
    private Date return_date;

    @ColumnInfo(name = "status")
    private Long status;

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

    public Order() {
    }

    public Order(Long uuid, Long customer_id, String description, Date borrowed_day, Date due_date, Date return_date,
            Long status, Date created_at, Long created_by, Date updated_at, Long updated_by, Date deleted_at,
            Long deleted_by) {
        this.uuid = uuid;
        this.customer_id = customer_id;
        this.description = description;
        this.borrowed_day = borrowed_day;
        this.due_date = due_date;
        this.return_date = return_date;
        this.status = status;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBorrowed_day() {
        return borrowed_day;
    }

    public void setBorrowed_day(Date borrowed_day) {
        this.borrowed_day = borrowed_day;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Order{" +
                "uuid=" + uuid +
                ", customer_id=" + customer_id +
                ", description='" + description + '\'' +
                ", borrowed_day=" + borrowed_day +
                ", due_date=" + due_date +
                ", return_date=" + return_date +
                ", status=" + status +
                ", created_at=" + created_at +
                ", created_by=" + created_by +
                ", updated_at=" + updated_at +
                ", updated_by=" + updated_by +
                ", deleted_at=" + deleted_at +
                ", deleted_by=" + deleted_by +
                '}';
    }
}
