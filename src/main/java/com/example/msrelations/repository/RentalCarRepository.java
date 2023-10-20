package com.example.msrelations.repository;

import com.example.msrelations.domain.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar,Long> {
}
