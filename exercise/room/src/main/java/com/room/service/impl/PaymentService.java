package com.room.service.impl;

import com.room.model.Payment;
import com.room.repository.IPaymentRepository;
import com.room.service.itf.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public List<Payment> findList() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment search(int id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
