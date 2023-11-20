package com.example.msrelations.service;

import com.example.msrelations.dto.request.HotelRequest;
import com.example.msrelations.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {

    List<HotelResponse> findAll();
    HotelResponse findById(Long id);
    HotelResponse save(HotelRequest hotelRequest);
    HotelResponse update(Long id,HotelRequest hotelRequest);
    void delete(Long id);
}
