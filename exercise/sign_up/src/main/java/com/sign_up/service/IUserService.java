package com.sign_up.service;

import com.sign_up.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    boolean addOne(User user);

    User findOne(String username);
}
