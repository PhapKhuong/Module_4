package com.picture.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fbId;
    private int point;
    private String author;
    private String content;
    private Date initDate;
    private int like;

    public Feedback() {
    }

    public Feedback(int fbId) {
        this.fbId = fbId;
    }

    public Feedback(int point, String author, String content, Date initDate) {
        this.point = point;
        this.author = author;
        this.content = content;
        this.initDate = initDate;
    }

    public Feedback(int fbId, int point, String author, String content, Date initDate, int like) {
        this.fbId = fbId;
        this.point = point;
        this.author = author;
        this.content = content;
        this.initDate = initDate;
        this.like = like;
    }

    public int getFbId() {
        return fbId;
    }

    public void setFbId(int fbId) {
        this.fbId = fbId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
