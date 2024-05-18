package com.urzica_mihai.siemens_assesment.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private Long id;
    private int roomNumber;
    private int type;
    private int price;
    private boolean isAvailable;
}
