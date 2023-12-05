package com.example.msrelations.repository;

import com.example.msrelations.registration.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRegistrationRepository extends JpaRepository<Registration, UUID> {

    Boolean existByUserEmail(String email);

    Registration findByEmailIgnoreCase(String emailId);
}
