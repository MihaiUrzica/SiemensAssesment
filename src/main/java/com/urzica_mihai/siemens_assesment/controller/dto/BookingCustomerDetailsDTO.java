package com.urzica_mihai.siemens_assesment.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookingCustomerDetailsDTO {
    private String name;
    private int numberOfNights;
    private int numberOfPersons;
}
