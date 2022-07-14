package com.examination.repository;

import com.examination.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = " select * from room where status = 0 ", nativeQuery = true)
    List<Room> getAllRoom();

    @Modifying
    @Transactional
    @Query(value = " UPDATE room SET `status` = 1 WHERE (`room_code` = :roomCode ); ", nativeQuery = true)
    void setStatus(@Param("roomCode") String roomCode);

    @Modifying
    @Transactional
    @Query(value = " UPDATE room SET `status` = 0 WHERE (`id` = :roomId ); ", nativeQuery = true)
    void updateStatus(@Param("roomId") Integer roomId);
}
