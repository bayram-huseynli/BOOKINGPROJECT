package com.example.msrelations.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "payments")
public class    Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long paymentId;

    Double paymentAmount;

    String paymentMethod;

    String paymentDate;


    @OneToOne(mappedBy = "payment")
    Booking booking;

}
