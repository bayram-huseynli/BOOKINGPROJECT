package com.example.msrelations.service.Impl;

import com.example.msrelations.domain.RentalCar;
import com.example.msrelations.dto.request.RentalCarRequest;
import com.example.msrelations.dto.response.RentalCarResponse;
import com.example.msrelations.repository.RentalCarRepository;
import com.example.msrelations.service.RentalCarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalCarServiceImpl implements RentalCarService {

    private final RentalCarRepository rentalCarRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<RentalCarResponse> findAll() {
        List<RentalCarResponse> rentalCarResponses= rentalCarRepository
                .findAll()
                .stream()
                .map(rentalCar -> modelMapper.map(rentalCar,RentalCarResponse.class))
                .toList();
        return rentalCarResponses;
    }

    @Override
    public RentalCarResponse findById(Long id) {
        RentalCar rentalCar=rentalCarRepository.findById(id).orElseThrow(()-> new RuntimeException());
        RentalCarResponse rentalCarResponse=modelMapper.map(rentalCar,RentalCarResponse.class);
        return rentalCarResponse;
    }

    @Override
    public RentalCarResponse save(RentalCarRequest rentalCarRequest) {
        RentalCar rentalCar=modelMapper.map(rentalCarRequest,RentalCar.class);
        rentalCarRepository.save(rentalCar);
        RentalCarResponse rentalCarResponse=modelMapper.map(rentalCar,RentalCarResponse.class);
        return rentalCarResponse;
    }

    @Override
    public RentalCarResponse update(Long id, RentalCarRequest rentalCarRequest) {
        RentalCar rentalCar=rentalCarRepository.findById(id).orElseThrow(()-> new RuntimeException());
        modelMapper.map(rentalCarRequest,RentalCar.class);
        rentalCar.setId(id);
        return modelMapper.map(rentalCarRepository.save(rentalCar),RentalCarResponse.class);
    }

    @Override
    public void delete(Long id) {
        RentalCar rentalCar=rentalCarRepository.findById(id).orElseThrow(()-> new RuntimeException());
        rentalCarRepository.delete(rentalCar);

    }
}
