package com.examination.service;

import com.examination.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRoom();

    void setStatus(String roomCode);

    void updateStatus(Integer id);
}
