package com.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<Card> cardSet;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String description, int quantity, Set<Card> cardSet) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.cardSet = cardSet;
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

    public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }
}
