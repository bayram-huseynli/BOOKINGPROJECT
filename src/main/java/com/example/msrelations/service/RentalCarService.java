package com.example.msrelations.service;

import com.example.msrelations.dto.request.RentalCarRequest;
import com.example.msrelations.dto.response.RentalCarResponse;

import java.util.List;

public interface RentalCarService {

    List<RentalCarResponse> findAll();

    RentalCarResponse findById(Long id);

    RentalCarResponse save(RentalCarRequest rentalCarRequest);

    RentalCarResponse update(Long id,RentalCarRequest rentalCarRequest);

    void delete(Long id);

}
