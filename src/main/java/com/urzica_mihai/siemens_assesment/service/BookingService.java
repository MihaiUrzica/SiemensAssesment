package com.urzica_mihai.siemens_assesment.service;

import com.urzica_mihai.siemens_assesment.controller.dto.BookingCustomerDetailsDTO;
import com.urzica_mihai.siemens_assesment.controller.dto.FeedbackDTO;
import com.urzica_mihai.siemens_assesment.controller.dto.RoomDTO;
import com.urzica_mihai.siemens_assesment.dao.entity.BookingEntity;
import com.urzica_mihai.siemens_assesment.dao.entity.FeedbackEntity;
import com.urzica_mihai.siemens_assesment.dao.entity.HotelEntity;
import com.urzica_mihai.siemens_assesment.dao.entity.RoomEntity;
import com.urzica_mihai.siemens_assesment.dao.repository.BookingRepository;
import com.urzica_mihai.siemens_assesment.dao.repository.RoomRepository;
import com.urzica_mihai.siemens_assesment.exception.CancelationNotAllowedException;
import com.urzica_mihai.siemens_assesment.exception.NotFoundException;
import com.urzica_mihai.siemens_assesment.exception.RoomAlreadyBookedException;
import com.urzica_mihai.siemens_assesment.utils.mapper.BookingMapper;
import com.urzica_mihai.siemens_assesment.utils.mapper.FeedbackMapper;
import com.urzica_mihai.siemens_assesment.utils.mapper.RoomMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BookingService {

    private static final String ROOM_NOT_FOUND = "Room not Found!";
    private static final String ROOM_IS_ALREADY_BOOKED = "Room is already booked!";
    private static final String BOOKING_NOT_FOUND = "Booking Not Found!";
    private static final String CANCELLATION_TIME_PASSED = "Cancellation only available with max 2 hours before check in!";

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public List<RoomDTO> findAvailableRoomsForHotel(Long hotelId) {
        List<RoomEntity> availableRooms = roomRepository.findRoomsByHotelId(hotelId).stream()
                .filter(RoomEntity::isAvailable)
                .collect(Collectors.toList());

        return RoomMapper.MAPPER.mapRoomEntitiesToRoomDTOS(availableRooms);
    }

    public BookingCustomerDetailsDTO bookRoom(Long roomId, BookingCustomerDetailsDTO bookingCustomerDetailsDTO) {

        RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() -> new NotFoundException(ROOM_NOT_FOUND));
        if (roomEntity.isAvailable()) {
            BookingEntity bookingEntity = BookingMapper.MAPPER.mapBookingCustomerDetailsDTOToEntity(bookingCustomerDetailsDTO);
            roomEntity.getBookings().add(bookingEntity);
            roomEntity.setAvailable(false);
            roomRepository.save(roomEntity);

            return bookingCustomerDetailsDTO;
        }
        else throw new RoomAlreadyBookedException(ROOM_IS_ALREADY_BOOKED);
    }

    @Transactional
    public void cancelBooking(Long hotelId, Long roomId, Long bookingId) {
        HotelEntity hotelEntity = hotelService.findById(hotelId);
        BookingEntity bookingEntity = bookingRepository.findById(bookingId).orElseThrow(() -> new NotFoundException(BOOKING_NOT_FOUND));
        if (hotelEntity.getCheckIn().isBefore(LocalTime.now().plusHours(2))) {
            throw new CancelationNotAllowedException(CANCELLATION_TIME_PASSED);
        } else {
            RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() -> new NotFoundException(ROOM_NOT_FOUND));
            roomEntity.setAvailable(true);
            roomRepository.save(roomEntity);
            bookingRepository.delete(bookingEntity);
        }
    }

    public FeedbackDTO leaveFeedback(Long hotelId, Long bookingId, FeedbackDTO feedbackDTO) {
        if (bookingRepository.findById(bookingId).isPresent()) {
            FeedbackEntity feedbackEntity = FeedbackMapper.MAPPER.mapFeedbackDTOToEntity(feedbackDTO);
            HotelEntity hotelEntity = hotelService.findById(hotelId);
            hotelEntity.getFeedbacks().add(feedbackEntity);
            hotelService.save(hotelEntity);
            return feedbackDTO;
        }
        else throw new NotFoundException("Can only leave feedback if you booked room in the Hotel!");
    }

}
