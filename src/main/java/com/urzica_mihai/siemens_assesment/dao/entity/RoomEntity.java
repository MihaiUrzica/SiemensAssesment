package com.urzica_mihai.siemens_assesment.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "roomNumber")
    @JsonProperty(value = "roomNumber")
    private int roomNumber;

    @Column(name = "type")
    @JsonProperty(value = "type")
    private int type;

    @Column(name = "price")
    @JsonProperty(value = "price")
    private int price;

    @Column(name = "isAvailable")
    @JsonProperty(value = "isAvailable")
    private boolean isAvailable;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private List<BookingEntity> bookings = new ArrayList<>();
}
