package com.libraries_trung.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    private String author;
    private String description;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<CardBook> cardBookSet;

    public Book() {
    }

    public Book(int bookId) {
        this.bookId = bookId;
    }

    public Book(int bookId, String bookName, String author, String description, int quantity, Set<CardBook> cardBookSet) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.cardBookSet = cardBookSet;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<CardBook> getCardBookSet() {
        return cardBookSet;
    }

    public void setCardBookSet(Set<CardBook> cardBookSet) {
        this.cardBookSet = cardBookSet;
    }
}
