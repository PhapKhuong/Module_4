package com.picture.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table (name = "fb")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fbId;
    private int rate;
    private String author;
    private String content;
    private String initDate;
    @ColumnDefault("0")
    private int liked;

    public Feedback() {
    }

    public Feedback(int fbId) {
        this.fbId = fbId;
    }

    public Feedback(int rate, String author, String content, String initDate) {
        this.rate = rate;
        this.author = author;
        this.content = content;
        this.initDate = initDate;
    }

    public Feedback(int fbId, int rate, String author, String content, String initDate, int liked) {
        this.fbId = fbId;
        this.rate = rate;
        this.author = author;
        this.content = content;
        this.initDate = initDate;
        this.liked = liked;
    }

    public int getFbId() {
        return fbId;
    }

    public void setFbId(int fbId) {
        this.fbId = fbId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int point) {
        this.rate = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int like) {
        this.liked = like;
    }
}
