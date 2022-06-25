package com.phuong.service;

import com.phuong.model.Music;
import com.phuong.model.MusicDto;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music getById(Integer id);
}
