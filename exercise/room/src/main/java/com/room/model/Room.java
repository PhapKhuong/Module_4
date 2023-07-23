package com.room.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Room {
    @Id
    private String roomId;
    @Column(name = "room_name")
    private String roomName;
    private String phone;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private Payment payment;
    private String note;

    public Room() {
    }

    public Room(String roomId, String roomName, String phone, LocalDate date, Payment payment, String note) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
