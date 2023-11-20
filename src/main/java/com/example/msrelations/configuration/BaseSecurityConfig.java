package com.example.msrelations.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class BaseSecurityConfig {
    private static final String SWAGGER_UI = "/swagger-ui/**";

    private static final String SWAGGER_HTML = "/swagger-ui.html**";

    private static final String ACTUATOR = "/actuator/**";


    @Bean
    public CustomAuthenticationEntryPoint unauthorizedHandler(){
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/test/**").permitAll()
                        .anyRequest().authenticated());



        return http.build();
    }

    protected CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration;
        return corsConfigurationSource();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
