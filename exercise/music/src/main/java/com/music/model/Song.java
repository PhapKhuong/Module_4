package com.music.model;

import org.springframework.web.multipart.MultipartFile;

public class Song {
    private int sId;
    private String name;
    private String singer;
    private MusicType musicType;
    private MultipartFile file;

    public Song() {
    }

    public Song(int sId, String name, String singer, MusicType musicType) {
        this.sId = sId;
        this.name = name;
        this.singer = singer;
        this.musicType = musicType;
    }

    public Song(int sId, String name, String singer, MusicType musicType, MultipartFile file) {
        this.sId = sId;
        this.name = name;
        this.singer = singer;
        this.musicType = musicType;
        this.file = file;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
