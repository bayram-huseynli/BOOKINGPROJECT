package com.example.msrelations.service.Impl;

import com.example.msrelations.domain.User;
import com.example.msrelations.dto.request.UserRequest;
import com.example.msrelations.dto.response.UserResponse;
import com.example.msrelations.repository.UserRepository;
import com.example.msrelations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .toList();
    }
    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);

    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id-%s", id)
        ));
        return modelMapper.map(user, UserResponse.class);
    }
    @Override
    public UserResponse update(Long userId, UserRequest userRequest) {
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found for updating by id -%s", userId)));
        User responseUser = modelMapper.map(userRequest, User.class);
        responseUser.setUserId(userId);
        return modelMapper.map(userRepository.save(responseUser), UserResponse.class);

    }
    @Override
    public void delete(Long id) {
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException(
                String.format("User not found by Id-%s",id)
        ));
     userRepository.delete(user);

    }
}
