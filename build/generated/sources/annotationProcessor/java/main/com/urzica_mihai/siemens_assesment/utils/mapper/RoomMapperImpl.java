package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.RoomDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.RoomEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:55:39+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomDTO mapRoomEntityToDTO(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId( roomEntity.getId() );
        roomDTO.setRoomNumber( roomEntity.getRoomNumber() );
        roomDTO.setType( roomEntity.getType() );
        roomDTO.setPrice( roomEntity.getPrice() );
        roomDTO.setAvailable( roomEntity.isAvailable() );

        return roomDTO;
    }

    @Override
    public List<RoomDTO> mapRoomEntitiesToRoomDTOS(List<RoomEntity> roomEntities) {
        if ( roomEntities == null ) {
            return null;
        }

        List<RoomDTO> list = new ArrayList<RoomDTO>( roomEntities.size() );
        for ( RoomEntity roomEntity : roomEntities ) {
            list.add( mapRoomEntityToDTO( roomEntity ) );
        }

        return list;
    }
}
