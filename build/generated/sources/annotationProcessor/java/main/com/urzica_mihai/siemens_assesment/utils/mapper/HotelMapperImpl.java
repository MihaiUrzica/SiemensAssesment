package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.HotelDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:55:39+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelDTO mapHotelEntityToDTO(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setId( hotelEntity.getId() );
        hotelDTO.setName( hotelEntity.getName() );
        hotelDTO.setLatitude( hotelEntity.getLatitude() );
        hotelDTO.setLongitude( hotelEntity.getLongitude() );
        hotelDTO.setCheckIn( hotelEntity.getCheckIn() );
        hotelDTO.setCheckOut( hotelEntity.getCheckOut() );

        return hotelDTO;
    }

    @Override
    public List<HotelDTO> mapHotelEntitiesToHotelDTOS(List<HotelEntity> hotelEntities) {
        if ( hotelEntities == null ) {
            return null;
        }

        List<HotelDTO> list = new ArrayList<HotelDTO>( hotelEntities.size() );
        for ( HotelEntity hotelEntity : hotelEntities ) {
            list.add( mapHotelEntityToDTO( hotelEntity ) );
        }

        return list;
    }
}
