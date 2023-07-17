package com.libraries.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Card {
    @Id
    private String cardId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @OneToMany(mappedBy = "card")
    private Set<CardBook> cardBookSet;

    public Card() {
    }

    public Card(String cardId, Student student, Set<CardBook> cardBookSet) {
        this.cardId = cardId;
        this.student = student;
        this.cardBookSet = cardBookSet;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<CardBook> getCardBookSet() {
        return cardBookSet;
    }

    public void setCardBookSet(Set<CardBook> cardBookSet) {
        this.cardBookSet = cardBookSet;
    }
}
