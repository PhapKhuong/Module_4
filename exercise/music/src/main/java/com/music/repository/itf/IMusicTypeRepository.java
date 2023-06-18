package com.music.repository.itf;

import com.music.model.MusicType;

import java.util.List;

public interface IMusicTypeRepository {
    List<MusicType> showList();

    MusicType search(int id);
}
