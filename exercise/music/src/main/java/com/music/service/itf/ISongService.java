package com.music.service.itf;

import com.music.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showList();

    void add(Song song);
}
