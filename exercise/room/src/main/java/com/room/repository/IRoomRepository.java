package com.room.repository;

import com.room.model.Room;
import com.room.query.RoomQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room, String> {
    @Query(value = RoomQuery.SELECT_PAGE_ROOM, nativeQuery = true)
    Page<Room> findRoomPage(Pageable pageable,
                            @Param("input") String input);

    @Query(value = RoomQuery.SELECT_LIST_ROOM, nativeQuery = true)
    List<Room> findRoomList();
}
