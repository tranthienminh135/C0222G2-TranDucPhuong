package com.phuong.service.impl;

import com.phuong.model.Music;
import com.phuong.model.MusicDto;
import com.phuong.repository.IMusicRepository;
import com.phuong.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return this.musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.musicRepository.save(music);
    }

    @Override
    public Music getById(Integer id) {
        return this.musicRepository.getById(id);
    }
}
