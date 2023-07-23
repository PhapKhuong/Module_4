package com.room.service.itf;

import com.room.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoomService {
    List<Room> findList();

    Page<Room> findPage(Pageable pageable, String name);

    void delete(Room room);

    void create(Room room);

    void update(Room room);

    Room findOne(String id);
}
