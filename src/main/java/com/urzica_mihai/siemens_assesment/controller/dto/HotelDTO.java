package com.urzica_mihai.siemens_assesment.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private LocalTime checkIn;
    private LocalTime checkOut;
}
