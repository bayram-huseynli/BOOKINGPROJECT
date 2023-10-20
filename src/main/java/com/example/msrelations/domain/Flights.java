package com.example.msrelations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String airline;


    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Booking booking;


}
