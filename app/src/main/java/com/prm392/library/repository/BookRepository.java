package com.prm392.library.repository;

import android.content.Context;

import com.prm392.library.DAO.BookDAO;
import com.prm392.library.database.LibraryApp;
import com.prm392.library.entities.Book;

public class BookRepository {
    private BookDAO bookDAO;

    public BookRepository(Context context) {
        LibraryApp libraryApp = LibraryApp.getInstance(context);
        bookDAO = libraryApp.bookDAO();
    }
    public void addBook(Book book){
        bookDAO.insertBook(book);
    }
}
