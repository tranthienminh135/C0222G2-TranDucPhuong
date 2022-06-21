package com.phuong.service;

import com.phuong.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAllMusic();

    void save(Music music);

    void delete(int id);

    Music findById(int id);

    void update(Music music);
}
