package com.room.model.dto;

import com.room.model.Payment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class RoomDto implements Validator {
    private String roomId;
    private String roomName;
    private String phone;
    private LocalDate date;
    private Payment payment;
    private String note;

    public RoomDto() {
    }

    public RoomDto(String roomId, String roomName, String phone, LocalDate date, Payment payment, String note) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RoomDto roomDto = (RoomDto) target;
        if (roomDto.getRoomId() != null && !roomDto.getRoomId().matches("^P-[\\d]{4}$")) {
            errors.rejectValue("username", null, "Room name is not formatted correctly!");
        }

        String roomName = roomDto.getRoomName();
        if (roomName.isEmpty()) {
            errors.rejectValue("roomName", null, "Room name is not empty!");
        } else if (roomName.length() < 5 || roomName.length() > 50) {
            errors.rejectValue("roomName", null, "Name is not shorter 5 and longer 50");
        }

        if (roomDto.getPhone().isEmpty()) {
            errors.rejectValue("phone", null, "Phone is not empty!");
        } else if (!roomDto.getPhone().matches("^[\\d]{10}$")) {
            errors.rejectValue("phone", null, "Phone is not formatted correctly!");
        }

        LocalDate rentalDate = roomDto.getDate();
        if (rentalDate == null) {
            errors.rejectValue("date", null, "Rental date is not empty and is formatted dd-MM-yyyy!");
        } else {
            LocalDate now = LocalDate.now();
            boolean check = rentalDate.isBefore(now);
            if (check) {
                errors.rejectValue("date", null, "Rental date can't be past date!");
            }
        }

        String note = roomDto.getNote();
        if (note.length() > 200) {
            errors.rejectValue("note", null, "Note is not longer 200!");
        }
    }
}