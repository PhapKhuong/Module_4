package com.forex.service;

import com.forex.repository.IMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.model.Money;

import java.util.List;

@Service
public class MoneyServiceImpl implements IMoneyService {
    @Autowired
    private IMoneyRepository repository;

    @Override
    public List<Money> display() {
        return repository.display();
    }

    @Override
    public Money search(int id) {
        return repository.search(id);
    }
}
