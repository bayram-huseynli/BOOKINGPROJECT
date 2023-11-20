package com.example.msrelations.configuration;

import org.springframework.security.core.Authentication;

public interface ClaimSetProvider {

    ClaimSet provide(Authentication authentication);
}
