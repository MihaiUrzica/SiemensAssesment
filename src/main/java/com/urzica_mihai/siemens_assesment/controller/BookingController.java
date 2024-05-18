package com.urzica_mihai.siemens_assesment.controller;

import com.urzica_mihai.siemens_assesment.controller.dto.BookingCustomerDetailsDTO;
import com.urzica_mihai.siemens_assesment.controller.dto.FeedbackDTO;
import com.urzica_mihai.siemens_assesment.controller.dto.RoomDTO;
import com.urzica_mihai.siemens_assesment.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/booking")
@AllArgsConstructor
@NoArgsConstructor
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/findAvailableRoomsForHotel/{hotelId}")
    public ResponseEntity<List<RoomDTO>> findAvailableRooms(@PathVariable Long hotelId){
        return new ResponseEntity<>(bookingService.findAvailableRoomsForHotel(hotelId), HttpStatus.OK);
    }

    @PostMapping(value = "/bookRoomWithId/{roomId}")
    public ResponseEntity<BookingCustomerDetailsDTO> bookRoom(@PathVariable Long roomId, @RequestBody BookingCustomerDetailsDTO detailsDTO){
        return new ResponseEntity<>(bookingService.bookRoom(roomId,detailsDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = "/cancelBooking/{hotelId}/{roomId}/{bookingId}")
    public ResponseEntity cancelBookingReservation(@PathVariable Long hotelId,
                                                   @PathVariable Long roomId,
                                                   @PathVariable Long bookingId){
        bookingService.cancelBooking(hotelId,roomId,bookingId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/leaveFeedback/{hotelId}/{bookingId}")
    public ResponseEntity<FeedbackDTO> leaveFeedback(@PathVariable Long bookingId, @PathVariable Long hotelId,
                                                     @RequestBody FeedbackDTO feedbackDTO){
        return new ResponseEntity<>(bookingService.leaveFeedback(hotelId,bookingId,feedbackDTO), HttpStatus.OK);
    }

}
