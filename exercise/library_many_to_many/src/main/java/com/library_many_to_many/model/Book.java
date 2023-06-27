package com.library_many_to_many.model;

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

    @ManyToMany()
    @JoinTable(name = "card")
    @JoinColumn(columnDefinition = "bookId", referencedColumnName = "stuId")
    private Set<Student> studentSet;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String description, int quantity, Set<Student> studentSet) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.studentSet = studentSet;
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

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
