package com.libraries_trung.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CardBook {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int cardBookId;

    private boolean status;
    @Column(name = "loan_date")
    private LocalDateTime loanDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "cardId")
    private Card card;

    public CardBook() {
    }

    public CardBook(int cardBookId, boolean status, LocalDateTime loanDate, LocalDateTime returnDate, Book book, Card card) {
        this.cardBookId = cardBookId;
        this.status = status;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.book = book;
        this.card = card;
    }

    public int getCardBookId() {
        return cardBookId;
    }

    public void setCardBookId(int cardBookId) {
        this.cardBookId = cardBookId;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
