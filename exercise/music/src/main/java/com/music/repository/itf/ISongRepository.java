package com.music.repository.itf;

import com.music.model.Song;

import java.util.Map;

public interface ISongRepository {
    Map<Song, String> showList();

    void add(Song song);
}
