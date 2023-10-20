package com.example.msrelations.dto.response;

import com.example.msrelations.domain.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightResponse {

    Long id;

    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String airline;

    Booking booking;
}
