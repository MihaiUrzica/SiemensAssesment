package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.BookingCustomerDetailsDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.BookingEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:55:39+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingEntity mapBookingCustomerDetailsDTOToEntity(BookingCustomerDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setName( dto.getName() );
        bookingEntity.setNumberOfNights( dto.getNumberOfNights() );
        bookingEntity.setNumberOfPersons( dto.getNumberOfPersons() );

        return bookingEntity;
    }
}
