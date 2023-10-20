package com.example.msrelations.service;

import com.example.msrelations.dto.request.BookingRequest;
import com.example.msrelations.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse findById(Long id);
    List<BookingResponse> findAll();
    BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest);

    void delete(Long id);
}
