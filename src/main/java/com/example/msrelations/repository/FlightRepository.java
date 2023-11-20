package com.example.msrelations.repository;

import com.example.msrelations.domain.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights,Long> {
}
