package com.library.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CardKey implements Serializable {
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "stu_id")
    private int stuId;

    public CardKey() {
    }

    public CardKey(int bookId, int stuId) {
        this.bookId = bookId;
        this.stuId = stuId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
}
