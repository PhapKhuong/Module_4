package com.music.service.itf;

import com.music.model.Song;

import java.util.Map;

public interface ISongService {
    Map<Song, String> showList();

    void add(Song song);
}
