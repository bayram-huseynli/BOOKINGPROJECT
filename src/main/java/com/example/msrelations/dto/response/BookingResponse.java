package com.example.msrelations.dto.response;

import com.example.msrelations.domain.Flights;
import com.example.msrelations.domain.Hotel;
import com.example.msrelations.domain.RentalCar;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {

   Long id;

   String bookingDate;

   Double totalCost;

   List<Flights> flights;

   List<Hotel> hotels;

   List<RentalCar> rentalCars;

   PaymentResponse payment;

}
