package com.example.msrelations.service.Impl;

import com.example.msrelations.domain.Payment;
import com.example.msrelations.dto.request.PaymentRequest;
import com.example.msrelations.dto.response.PaymentResponse;
import com.example.msrelations.repository.PaymentRepository;
import com.example.msrelations.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PaymentResponse> findAll() {
        List<PaymentResponse> paymentResponses=paymentRepository
                .findAll()
                .stream()
                .map(payment -> modelMapper.map(payment,PaymentResponse.class))
                .toList();
        return paymentResponses;
    }

    @Override
    public PaymentResponse findById(Long paymentId) {
        Payment payment=paymentRepository.findById(paymentId).orElseThrow(()-> new NotFoundException("Id not found"));
        PaymentResponse paymentResponse=modelMapper.map(payment,PaymentResponse.class);
        return paymentResponse;
    }

    @Override
    public PaymentResponse savePayment(PaymentRequest paymentRequest) {
        Payment payment=modelMapper.map(paymentRequest,Payment.class);
        return modelMapper.map(paymentRepository.save(payment),PaymentResponse.class);
    }

    @Override
    public PaymentResponse update(Long paymentId,PaymentRequest paymentRequest) {
        Payment payment=paymentRepository.findById(paymentId).orElseThrow(()-> new NotFoundException("not found id"));
        modelMapper.map(paymentRequest,Payment.class);
        payment.setPaymentId(paymentId);
        return modelMapper.map(paymentRepository.save(payment),PaymentResponse.class);

    }

    @Override
    public void delete(Long id) {
        Payment payment=paymentRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found id"));
        paymentRepository.delete(payment);
    }


}
