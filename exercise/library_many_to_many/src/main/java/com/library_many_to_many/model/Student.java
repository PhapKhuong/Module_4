package com.library_many_to_many.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuId;
    private String stuName;
    private String grade;

    @ManyToMany(mappedBy = "studentSet")
    private Set<Book> bookSet;

    public Student() {
    }

    public Student(int stuId, String stuName, String grade, Set<Book> bookSet) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.grade = grade;
        this.bookSet = bookSet;
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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
