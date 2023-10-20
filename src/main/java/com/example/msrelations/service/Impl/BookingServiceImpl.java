package com.example.msrelations.service.Impl;

import com.example.msrelations.domain.Booking;
import com.example.msrelations.domain.Payment;
import com.example.msrelations.domain.User;
import com.example.msrelations.dto.request.BookingRequest;
import com.example.msrelations.dto.response.BookingResponse;
import com.example.msrelations.repository.BookingRepository;
import com.example.msrelations.repository.PaymentRepository;
import com.example.msrelations.repository.UserRepository;
import com.example.msrelations.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

    public List<BookingResponse> findAll(){
        List<BookingResponse> bookingResponses=bookingRepository
                .findAll()
                .stream()
                .map(booking->modelMapper.map(booking,BookingResponse.class))
                .toList();
        return bookingResponses;
    }
    public BookingResponse findById(Long id){
        Booking booking=bookingRepository.findById(id).orElseThrow(()-> new RuntimeException(
                String.format("Booking not found by id -%s",id)
        ));
        BookingResponse bookingResponse=modelMapper.map(booking,BookingResponse.class);
        return bookingResponse;
    }
//    public BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest){
//        User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException(
//                String.format("User not found by id -%s",userId)
//        ));
//
//        Payment payment=paymentRepository.findById(paymentId).orElseThrow(()-> new RuntimeException(
//                String.format("Payment not found by id -%s",paymentId)
//        ));
//
//        Booking booking=modelMapper.map(bookingRepository,Booking.class);
//        booking.setPayment(payment);
//        booking.setUser(user);
//
//        return modelMapper.map(bookingRepository.save(booking),BookingResponse.class);
//
//    }
    @Override
    public BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest){
        User user=getUserById(userId);
        Payment payment=getPaymentById(paymentId);
        Booking booking=createBooking(user,payment,bookingRequest);
        return mapToBookingResponse(booking);
    }
    private User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException(
                String.format("User not found by id -%s",userId)
        ));
    }
    private Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id -%s", paymentId)
        ));
    }
    private Booking createBooking(User user,Payment payment,BookingRequest bookingRequest){
        Booking booking=modelMapper.map(bookingRequest,Booking.class);
        booking.setPayment(payment);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }
    private BookingResponse mapToBookingResponse(Booking booking){
        return modelMapper.map(booking,BookingResponse.class);
    }
    @Override
    public void delete(Long id){
        bookingRepository.findById(id).orElseThrow(()-> new RuntimeException(
                String.format("Booking not found by id -%s",id)
        ));

    }





}
