package com.example.msrelations.dto.request;

import com.example.msrelations.domain.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelRequest {

    String hotelName;

    String location;

    RoomType roomType;

    Double price;
}
