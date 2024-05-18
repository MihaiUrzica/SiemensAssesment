package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.RoomDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomMapper {

    RoomMapper MAPPER = Mappers.getMapper(RoomMapper.class);

    RoomDTO mapRoomEntityToDTO(RoomEntity roomEntity);

    List<RoomDTO> mapRoomEntitiesToRoomDTOS(List<RoomEntity> roomEntities);

}
