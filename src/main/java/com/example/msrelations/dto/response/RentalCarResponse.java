package com.example.msrelations.dto.response;

import com.example.msrelations.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentalCarResponse {

    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double price;

    String pickUpLocation;

    String dropOfLocation;

    Booking booking;
}
