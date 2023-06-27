package com.library.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Card {
    @EmbeddedId
    private CardKey id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_Id")
    private Book book;

    @ManyToOne
    @MapsId("stuId")
    @JoinColumn(name = "stu_Id")
    private Student student;

    private boolean status;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Card() {
    }

    public Card(CardKey id, Book book, Student student, boolean status, LocalDate loanDate, LocalDate returnDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public CardKey getId() {
        return id;
    }

    public void setId(CardKey id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
