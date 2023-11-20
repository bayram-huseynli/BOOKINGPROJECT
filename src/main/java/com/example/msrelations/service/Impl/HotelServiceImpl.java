package com.example.msrelations.service.Impl;

import com.example.msrelations.domain.Hotel;
import com.example.msrelations.dto.request.HotelRequest;
import com.example.msrelations.dto.response.HotelResponse;
import com.example.msrelations.repository.HotelRepository;
import com.example.msrelations.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;


    public List<HotelResponse> findAll(){
        List<HotelResponse> hotelResponses=hotelRepository
                .findAll()
                .stream()
                .map(hotel1 -> modelMapper.map(hotel1,HotelResponse.class))
                .toList();

        return hotelResponses;
    }

    @Override
    public HotelResponse findById(Long id) {
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()-> new RuntimeException());
        HotelResponse hotelResponse =modelMapper.map(hotel,HotelResponse.class);
        return hotelResponse;
    }

    @Override
    public HotelResponse save(HotelRequest hotelRequest) {
        Hotel hotel=modelMapper.map(hotelRequest,Hotel.class);
        hotelRepository.save(hotel);
        HotelResponse hotelResponse=modelMapper.map(hotel,HotelResponse.class);
        return hotelResponse;
    }

    @Override
    public HotelResponse update(Long id, HotelRequest hotelRequest) {
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()-> new RuntimeException());
        modelMapper.map(hotelRequest,Hotel.class);
        hotel.setId(id);
        return modelMapper.map(hotelRepository.save(hotel),HotelResponse.class);
    }

    @Override
    public void delete(Long id) {
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()-> new RuntimeException());
        hotelRepository.delete(hotel);
    }

}
