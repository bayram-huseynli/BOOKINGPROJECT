package com.example.msrelations.configuration;

import org.springframework.security.core.Authentication;

public interface ClaimProvider {

    Claim provide(Authentication authentication);
}
