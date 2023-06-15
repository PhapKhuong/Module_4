package com.account.service.impl;

import com.account.model.User;
import com.account.repository.itf.UserRepository;
import com.account.service.itf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public List<User> display() {
        return repository.display();
    }

    @Override
    public void update(User user) {
        repository.update(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void create(User user) {
        repository.create(user);
    }

    @Override
    public List<User> search(String name) {
        return repository.search(name);
    }
}
