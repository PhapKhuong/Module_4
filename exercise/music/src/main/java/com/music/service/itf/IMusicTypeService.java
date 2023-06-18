package com.music.service.itf;

import com.music.model.MusicType;

import java.util.List;

public interface IMusicTypeService {
    List<MusicType> showList();

    MusicType search(int id);
}
