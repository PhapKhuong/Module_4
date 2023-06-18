package com.music.repository.itf;

import com.music.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> showList();

    void add(Song song);
}
