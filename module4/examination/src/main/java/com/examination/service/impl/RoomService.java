package com.examination.service.impl;

import com.examination.model.Room;
import com.examination.repository.IRoomRepository;
import com.examination.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository roomRepository;

    @Override
    public List<Room> getAllRoom() {
        return this.roomRepository.getAllRoom();
    }

    @Override
    public void setStatus(String roomCode) {
        this.roomRepository.setStatus(roomCode);
    }

    @Override
    public void updateStatus(Integer id) {
        this.roomRepository.updateStatus(id);
    }
}
