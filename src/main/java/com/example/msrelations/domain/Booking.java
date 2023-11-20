package com.example.msrelations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String bookingDate;

    Double totalCost;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    User user;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Builder.Default
    List<Flights> flights=new ArrayList<>();

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Builder.Default
    List<Hotel> hotels=new ArrayList<>();

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Builder.Default
    List<RentalCar> rentalCars=new ArrayList<>();

    @OneToOne
    @JoinColumn(name="payment_id")
    @JsonIgnore
    @ToString.Exclude
    Payment payment;



}
