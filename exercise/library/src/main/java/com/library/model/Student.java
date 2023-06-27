package com.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuId;
    private String stuName;
    private String grade;

    @OneToMany(mappedBy = "student")
    private Set<Card> cardSet;

    public Student() {
    }

    public Student(int stuId, String stuName, String grade, Set<Card> cardSet) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.grade = grade;
        this.cardSet = cardSet;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }
}
