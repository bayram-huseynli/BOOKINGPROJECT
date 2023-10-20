package com.example.msrelations.dto.response;

import com.example.msrelations.domain.Booking;
import com.example.msrelations.domain.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {

    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double price;

    Booking booking;
}
