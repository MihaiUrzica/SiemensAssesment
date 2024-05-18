package com.urzica_mihai.siemens_assesment.controller;

import com.urzica_mihai.siemens_assesment.controller.dto.HotelDTO;
import com.urzica_mihai.siemens_assesment.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hotels")
@AllArgsConstructor
@NoArgsConstructor
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping(value = "/findHotelsInRange/{range}")
    public ResponseEntity<List<HotelDTO>> findHotelsInRange(@PathVariable int range){
        return new ResponseEntity<>(service.findHotelsInRange(range), HttpStatus.OK);
    }
}
