package com.example.msrelations.repository;

import com.example.msrelations.registration.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<ConfirmationToken,Long> {

    ConfirmationToken findByConfiramationToken(String confirmationToken);
}
