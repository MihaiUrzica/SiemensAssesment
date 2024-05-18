package com.urzica_mihai.siemens_assesment.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfNights")
    private int numberOfNights;

    @Column(name = "numberOfPersons")
    private int numberOfPersons;

}
