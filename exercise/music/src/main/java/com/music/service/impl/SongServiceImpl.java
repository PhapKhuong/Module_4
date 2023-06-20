package com.music.service.impl;

import com.music.model.Song;
import com.music.repository.itf.ISongRepository;
import com.music.service.itf.ISongService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SongServiceImpl implements ISongService {
    private ISongRepository repository;

    private SongServiceImpl(ISongRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<Song, String> showList() {
        return repository.showList();
    }

    @Override
    public void add(Song song) {
        repository.add(song);
    }
}
