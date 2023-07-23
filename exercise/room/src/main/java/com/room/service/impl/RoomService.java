package com.room.service.impl;

import com.room.model.Room;
import com.room.repository.IRoomRepository;
import com.room.service.itf.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository roomRepository;

    @Override
    public List<Room> findList() {
        return roomRepository.findRoomList();
    }

    public Page<Room> findPage(Pageable pageable, String name) {
        return roomRepository.findRoomPage(pageable, name);
    }

    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public void create(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void update(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room findOne(String id) {
        return roomRepository.findById(id).orElse(null);
    }
}
