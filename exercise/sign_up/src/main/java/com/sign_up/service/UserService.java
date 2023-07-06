package com.sign_up.service;

import com.sign_up.model.User;
import com.sign_up.repository.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository repository;

    private UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public boolean addOne(User user) {
        repository.save(user);
        return true;
    }

    @Override
    public User findOne(String username) {
        return repository.findById(username).orElse(null);
    }
}
