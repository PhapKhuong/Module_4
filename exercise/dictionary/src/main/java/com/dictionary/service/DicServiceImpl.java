package com.dictionary.service;

import com.dictionary.repository.IDicRepository;
import org.springframework.stereotype.Service;

@Service
public class DicServiceImpl implements IDicService {
    private IDicRepository repository;

    public DicServiceImpl(IDicRepository repository) {
        this.repository = repository;
    }

    @Override
    public String searchByE(String e) {
        return repository.searchByE(e);
    }

    @Override
    public String searchByV(String v) {
        return repository.searchByV(v);
    }
}
