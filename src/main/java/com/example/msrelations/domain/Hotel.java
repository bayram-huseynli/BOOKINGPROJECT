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
@Table(name = "hotels")
public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String hotelName;
    String location;

    @Enumerated(EnumType.STRING)
    RoomType roomType;
    Double price;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Booking booking;


}
