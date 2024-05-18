package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.BookingCustomerDetailsDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {

    BookingMapper MAPPER = Mappers.getMapper(BookingMapper.class);

    BookingEntity mapBookingCustomerDetailsDTOToEntity(BookingCustomerDetailsDTO dto);
}
