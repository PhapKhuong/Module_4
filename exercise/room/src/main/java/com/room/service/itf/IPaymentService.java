package com.room.service.itf;

import com.room.model.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> findList();

    Payment search(int id);
}
