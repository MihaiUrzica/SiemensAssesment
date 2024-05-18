package com.urzica_mihai.siemens_assesment.utils.mapper;

import com.urzica_mihai.siemens_assesment.controller.dto.FeedbackDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.FeedbackEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:55:39+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class FeedbackMapperImpl implements FeedbackMapper {

    @Override
    public FeedbackEntity mapFeedbackDTOToEntity(FeedbackDTO feedbackDTO) {
        if ( feedbackDTO == null ) {
            return null;
        }

        FeedbackEntity feedbackEntity = new FeedbackEntity();

        feedbackEntity.setFeedback( feedbackDTO.getFeedback() );

        return feedbackEntity;
    }
}
