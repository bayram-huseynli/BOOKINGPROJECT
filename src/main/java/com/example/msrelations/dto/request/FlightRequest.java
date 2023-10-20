package com.example.msrelations.dto.request;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightRequest {

    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String airline;
}
