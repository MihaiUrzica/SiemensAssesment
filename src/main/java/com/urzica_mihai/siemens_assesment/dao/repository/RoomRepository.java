package com.urzica_mihai.siemens_assesment.dao.repository;

import com.urzica_mihai.siemens_assesment.dao.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query(value = "SELECT * FROM rooms WHERE hotel_id = ?1", nativeQuery = true)
    List<RoomEntity> findRoomsByHotelId(Long id);

}
