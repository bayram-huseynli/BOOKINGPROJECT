package com.example.msrelations.dto.response;

import com.example.msrelations.domain.Booking;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long userId;

    String name;

    String surname;

    String email;

    String phoneNumber;

    List<BookingResponse> bookingList;


}
