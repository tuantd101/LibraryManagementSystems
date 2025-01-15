package com.prm392.library.entities;

import java.util.Date;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Customer")
public class Customer {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uuid")
    private Long uuid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "dob")
    private Date dob;

    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "email")
    private String email;

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

    public Customer() {
    }

    public Customer(Long uuid, String name, Date dob, Long id, String address, String phone, String email, Long status, Date created_at, Long created_by, Date updated_at, Long updated_by, Date deleted_at, Long deleted_by) {
        this.uuid = uuid;
        this.name = name;
        this.dob = dob;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "Customer{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                ", deleted_at=" + deleted_at +
                ", deleted_by='" + deleted_by + '\'' +
                '}';
    }
}
