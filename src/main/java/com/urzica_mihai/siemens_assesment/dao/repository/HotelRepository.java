package com.urzica_mihai.siemens_assesment.dao.repository;

import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
}
