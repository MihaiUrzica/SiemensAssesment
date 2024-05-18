package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.FeedbackDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.FeedbackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper {
    FeedbackMapper MAPPER = Mappers.getMapper(FeedbackMapper.class);

    FeedbackEntity mapFeedbackDTOToEntity(FeedbackDTO feedbackDTO);
}
