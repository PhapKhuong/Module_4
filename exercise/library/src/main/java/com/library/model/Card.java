package com.library.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Card {
    @Id
    private String cardId;

    @ManyToOne
    @JoinColumn(name = "book_Id", referencedColumnName = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    private boolean status;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    public Card() {
    }

    public Card(String cardId, LocalDateTime returnDate) {
        this.cardId = cardId;
        this.returnDate = returnDate;
    }

    public Card(String cardId, Book book) {
        this.cardId = cardId;
        this.book = book;
    }

    public Card(String cardId, Book book, Student student, boolean status, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.cardId = cardId;
        this.book = book;
        this.student = student;
        this.status = status;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
