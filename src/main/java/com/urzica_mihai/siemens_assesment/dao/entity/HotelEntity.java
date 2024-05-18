package com.urzica_mihai.siemens_assesment.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "checkIn")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime checkIn;

    @Column(name = "checkOut")
    private LocalTime checkOut;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private List<RoomEntity> rooms = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private List<FeedbackEntity> feedbacks = new ArrayList<>();
}
