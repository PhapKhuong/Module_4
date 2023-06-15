package com.account.service.impl;

import com.account.model.Role;
import com.account.repository.itf.RoleRepository;
import com.account.service.itf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository repository;

    @Override
    public Role search(int id) {
        return repository.search(id);
    }
}
