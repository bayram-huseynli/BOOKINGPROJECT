package com.example.msrelations.repository;

import com.example.msrelations.domain.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flights,Long> {
}
