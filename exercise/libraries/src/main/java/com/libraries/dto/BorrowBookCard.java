package com.libraries.dto;

import com.libraries.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BorrowBookCard {
    private Book book;
    private List<Book> bookListBorrow = new ArrayList<>();

    public BorrowBookCard() {
    }

    public BorrowBookCard(List<Book> bookListBorrow) {
        this.bookListBorrow = bookListBorrow;
    }

    public BorrowBookCard(Book book) {
        this.book = book;
        this.bookListBorrow.add(book);
    }

    public List<Book> getBookListBorrow() {
        return bookListBorrow;
    }

    public void setBookListBorrow(List<Book> bookListBorrow) {
        this.bookListBorrow.addAll(bookListBorrow);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
