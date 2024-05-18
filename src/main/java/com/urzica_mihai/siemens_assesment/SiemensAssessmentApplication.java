package com.urzica_mihai.siemens_assesment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import com.urzica_mihai.siemens_assesment.service.HotelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class SiemensAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiemensAssessmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(HotelService hotelService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<HotelEntity>> typeReference = new TypeReference<List<HotelEntity>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/hotels.json");
			try {
				List<HotelEntity> hotelEntities = mapper.readValue(inputStream,typeReference);
				hotelEntities.forEach(hotelEntity -> {
					hotelEntity.setCheckIn(LocalTime.of(12,0));
					hotelEntity.setCheckOut(LocalTime.of(14,0));
				});
				hotelService.saveAll(hotelEntities);
				System.out.println("Hotels Saved");
			}
			catch (IOException e){
				System.out.println("Unable to save Hotels: "+e.getMessage());
			}
		};
	}
}
