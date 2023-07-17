package com.libraries_trung.dto;

public class BorrowBookCard {
//    private Book book;
    private String bookListBorrow;

    public BorrowBookCard(){
    }

    public BorrowBookCard(String bookListBorrow){
        this.bookListBorrow = bookListBorrow;
    }

//    public BorrowBookCard(Book book, List<Book> bookList) {
//        this.book = book;
//        bookList.add(book);
//    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public String getBookListBorrow() {
        return bookListBorrow;
    }

    public void setBookListBorrow(String bookListBorrow) {
        this.bookListBorrow = bookListBorrow;
    }
}
