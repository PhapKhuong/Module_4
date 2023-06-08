package com.forex.service;

import com.forex.model.Money;

import java.util.List;

public interface IMoneyService {
    List<Money> display();

    Money search(int id);
}
