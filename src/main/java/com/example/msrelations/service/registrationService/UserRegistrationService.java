package com.example.msrelations.service.registrationService;

import com.example.msrelations.registration.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserRegistrationService {
    ResponseEntity<?> saveUser(Registration user);

    ResponseEntity<?> confirmEmail(String confirmationToken);
}
