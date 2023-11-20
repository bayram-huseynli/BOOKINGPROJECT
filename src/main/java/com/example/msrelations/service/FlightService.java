package com.example.msrelations.service;

import com.example.msrelations.dto.request.FlightRequest;
import com.example.msrelations.dto.response.FlightResponse;

import java.util.List;

public interface FlightService {

    List<FlightResponse> findAll();
    FlightResponse findById(Long id);
    FlightResponse update(Long id, FlightRequest flightRequest);
    FlightResponse save(FlightRequest flightRequest);

    void delete(Long id);
}
