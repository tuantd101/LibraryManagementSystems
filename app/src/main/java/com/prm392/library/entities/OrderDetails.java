package com.prm392.library.entities;

import java.util.Date;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "OrderDetails")
public class OrderDetails {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uuid")
    private Long uuid;

    @ColumnInfo(name = "order_uuid")
    private Long order_uuid;

    @ColumnInfo(name = "book_uuid")
    private Long book_uuid;

    @ColumnInfo(name = "description")
    private String description;

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

    public OrderDetails(Long uuid, Long order_uuid, Long book_uuid, String description, Date created_at, Long created_by, Date updated_at, Long updated_by, Date deleted_at, Long deleted_by) {
        this.uuid = uuid;
        this.order_uuid = order_uuid;
        this.book_uuid = book_uuid;
        this.description = description;
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

    public Long getOrder_uuid() {
        return order_uuid;
    }

    public void setOrder_uuid(Long order_uuid) {
        this.order_uuid = order_uuid;
    }

    public Long getBook_uuid() {
        return book_uuid;
    }

    public void setBook_uuid(Long book_uuid) {
        this.book_uuid = book_uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "OrderDetails{" +
                "uuid=" + uuid +
                ", order_uu_id=" + order_uuid +
                ", book_uu_id=" + book_uuid +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", created_by=" + created_by +
                ", updated_at=" + updated_at +
                ", updated_by=" + updated_by +
                ", deleted_at=" + deleted_at +
                ", deleted_by=" + deleted_by +
                '}';
    }
}
