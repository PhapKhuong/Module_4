package com.forex.repository;

import com.forex.model.Money;

import java.util.List;

public interface IMoneyRepository {
    List<Money> display();

    Money search(int id);
}
