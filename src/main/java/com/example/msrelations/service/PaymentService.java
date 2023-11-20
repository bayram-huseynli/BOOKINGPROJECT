package com.example.msrelations.service;

import com.example.msrelations.domain.Payment;
import com.example.msrelations.dto.request.PaymentRequest;
import com.example.msrelations.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    List<PaymentResponse> findAll();

    PaymentResponse findById(Long id);

    PaymentResponse savePayment(PaymentRequest paymentRequest);

    PaymentResponse update(Long id,PaymentRequest paymentRequest);
    void delete(Long id);




}
