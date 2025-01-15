package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.Book;

import java.util.List;
@Dao
public interface BookDAO {
    @Query("SELECT * FROM Book")
    List<Book> getAllBooks();

    @Query("SELECT * FROM Book WHERE uuid = :uuid")
    Book getBookById(Long uuid);

    @Insert
    void insertBook(Book book);

    @Update
    void updateBook(Book book);

    @Delete
    void deleteBook(Book book);
}

