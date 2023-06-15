package com.account.repository.itf;

import com.account.model.User;

import java.util.List;

public interface UserRepository {
    List<User> display();

    void update(User book);

    void delete(int id);

    void create (User book);

    List<User> search(String name);
}
