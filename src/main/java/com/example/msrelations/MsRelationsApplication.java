package com.example.msrelations;

import com.example.msrelations.domain.User;
import com.example.msrelations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@RequiredArgsConstructor
@SpringBootApplication
public class MsRelationsApplication implements CommandLineRunner {

     private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsRelationsApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        User user=User.builder()
                .userId(1L)
                .name("Bayram")
                .surname("Huseynli")
                .build();

        userRepository.save(user);
    }
}
