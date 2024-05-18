package com.urzica_mihai.siemens_assesment.service;

import com.urzica_mihai.siemens_assesment.controller.dto.HotelDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import com.urzica_mihai.siemens_assesment.dao.repository.HotelRepository;
import com.urzica_mihai.siemens_assesment.exception.NotFoundException;
import com.urzica_mihai.siemens_assesment.utils.mapper.HotelMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class HotelService {

    @Autowired
    private LocationService locationService;

    @Autowired
    private HotelRepository repository;

    public HotelEntity findById(Long hotelId){
        return repository.findById(hotelId).orElseThrow(() -> new NotFoundException("Hotel Not Found"));
    }

    public List<HotelDTO> findHotelsInRange(int range){

        List<HotelEntity> hotelsInRange = repository.findAll()
                .stream()
                .filter(hotel -> {
                    try {
                        return range > locationService.distanceFromHotel(hotel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());

        return HotelMapper.MAPPER.mapHotelEntitiesToHotelDTOS(hotelsInRange);
    }

    public HotelEntity save(HotelEntity hotelEntity){
        return repository.save(hotelEntity);
    }

    public List<HotelEntity> saveAll(List<HotelEntity> hotelEntities){
        return repository.saveAll(hotelEntities);
    }

}
