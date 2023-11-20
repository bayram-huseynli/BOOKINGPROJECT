package com.example.msrelations.controller;

import com.example.msrelations.dto.request.PaymentRequest;
import com.example.msrelations.dto.response.PaymentResponse;
import com.example.msrelations.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment/v1")
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/all")
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> savePayment(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.savePayment(paymentRequest),HttpStatus.CREATED);
    }

    @GetMapping("payment/v1/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.findById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<PaymentResponse> update(@PathVariable Long id,@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.update(id,paymentRequest),HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        paymentService.delete(id);
    }
}
