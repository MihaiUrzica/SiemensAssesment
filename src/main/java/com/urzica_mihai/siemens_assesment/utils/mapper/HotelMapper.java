package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.HotelDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    HotelMapper MAPPER = Mappers.getMapper(HotelMapper.class);

    HotelDTO mapHotelEntityToDTO(HotelEntity hotelEntity);
    List<HotelDTO> mapHotelEntitiesToHotelDTOS(List<HotelEntity> hotelEntities);
}
