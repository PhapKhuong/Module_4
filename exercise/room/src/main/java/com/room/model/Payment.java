package com.room.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @Column(name = "payment_name")
    private String paymentName;
    @OneToMany(mappedBy = "payment")
    private Set<Room> roomSet;

    public Payment() {
    }

    public Payment(int paymentId, String paymentName, Set<Room> roomSet) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.roomSet = roomSet;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }
}
