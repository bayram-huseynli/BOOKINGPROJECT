package com.example.msrelations.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentalCarRequest {

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double price;

    String pickUpLocation;

    String dropOfLocation;
}
