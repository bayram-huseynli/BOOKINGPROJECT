package com.example.msrelations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    String name;

    String surname;

    String email;

    String phoneNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Builder.Default
    List<Booking> bookingList=new ArrayList<>();


}
