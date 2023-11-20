package com.example.msrelations.service.Impl;

import com.example.msrelations.domain.Flights;
import com.example.msrelations.dto.request.FlightRequest;
import com.example.msrelations.dto.response.FlightResponse;
import com.example.msrelations.repository.FlightRepository;
import com.example.msrelations.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FlightResponse> findAll(){
        List<FlightResponse> flightsResponses =flightRepository
                .findAll()
                .stream()
                .map(flights1 -> modelMapper.map(flights1, FlightResponse.class))
                .toList();
        return flightsResponses;
    }
    @Override
    public FlightResponse findById(Long id){
        Flights flights=flightRepository.findById(id).orElseThrow(()-> new RuntimeException());
        FlightResponse flightResponse=modelMapper.map(flights,FlightResponse.class);
        return flightResponse;
    }

    @Override
    public FlightResponse update(Long id, FlightRequest flightRequest) {
        flightRepository.findById(id).orElseThrow(()-> new RuntimeException());
        Flights flights1=modelMapper.map(flightRequest,Flights.class);
        flights1.setId(id);
        return modelMapper.map(flightRepository.save(flights1),FlightResponse.class);
    }

    @Override
    public FlightResponse save(FlightRequest flightRequest) {
        Flights flight=modelMapper.map(flightRequest,Flights.class);
        flightRepository.save(flight);
        FlightResponse flightResponse=modelMapper.map(flight,FlightResponse.class);
        return flightResponse;
    }

    @Override
    public void delete(Long id) {
        Flights flights=flightRepository.findById(id).orElseThrow(()-> new RuntimeException());
        flightRepository.delete(flights);

    }

}
