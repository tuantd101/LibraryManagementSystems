package com.prm392.library.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Book")
public class Book {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uuid")
    private Long uuid;

    @ColumnInfo(name = "book_id")
    private Long book_id;

    @ColumnInfo(name = "book_name")
    private String name;

    @ColumnInfo(name = "supplier")
    private String supplier;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "status")
    private Long status;

    @ColumnInfo(name = "category")
    private Long category;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "order_id")
    private Long order_id;

    @ColumnInfo(name = "create_at")
    private Date create_at;

    @ColumnInfo(name = "create_by")
    private Long create_by;

    @ColumnInfo(name = "update_at")
    private Date update_at;

    @ColumnInfo(name = "update_by")
    private Long update_by;

    @ColumnInfo(name = "delete_at")
    private Date delete_at;

    @ColumnInfo(name = "delete_by")
    private Long delete_by;

    public Book() {
    }

    public Book(Long uuid, Long book_id, String name, String supplier, String author, Long status, Long category,
            String description, Long order_id, Date create_at, Long create_by, Date update_at, Long update_by,
            Date delete_at, Long delete_by) {
        this.uuid = uuid;
        this.book_id = book_id;
        this.name = name;
        this.supplier = supplier;
        this.author = author;
        this.status = status;
        this.category = category;
        this.description = description;
        this.order_id = order_id;
        this.create_at = create_at;
        this.create_by = create_by;
        this.update_at = update_at;
        this.update_by = update_by;
        this.delete_at = delete_at;
        this.delete_by = delete_by;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Long getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Long update_by) {
        this.update_by = update_by;
    }

    public Date getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(Date delete_at) {
        this.delete_at = delete_at;
    }

    public Long getDelete_by() {
        return delete_by;
    }

    public void setDelete_by(Long delete_by) {
        this.delete_by = delete_by;
    }

    @Override
    public String toString() {
        return "Book{" +
                "uuid=" + uuid +
                ", book_id=" + book_id +
                ", name='" + name + '\'' +
                ", supplier='" + supplier + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", order_id=" + order_id +
                ", create_at=" + create_at +
                ", create_by=" + create_by +
                ", update_at=" + update_at +
                ", update_by=" + update_by +
                ", delete_at=" + delete_at +
                ", delete_by=" + delete_by +
                '}';
    }
}
