package com.libraries.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    private String grade;

    @OneToMany(mappedBy = "student")
    private Set<Card> cardSet;

    public Student() {
    }

    public Student(int studentId, String studentName, String grade, Set<Card> cardSet) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
        this.cardSet = cardSet;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
