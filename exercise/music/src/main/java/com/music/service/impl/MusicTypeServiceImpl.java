package com.music.service.impl;

import com.music.model.MusicType;
import com.music.repository.itf.IMusicTypeRepository;
import com.music.service.itf.IMusicTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicTypeServiceImpl implements IMusicTypeService {
    private IMusicTypeRepository repository;

    private MusicTypeServiceImpl(IMusicTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MusicType> showList() {
        return repository.showList();
    }

    @Override
    public MusicType search(int id) {
        return null;
    }
}
