package com.example.msrelations.service;

import com.example.msrelations.dto.request.UserRequest;
import com.example.msrelations.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse saveUser(UserRequest userRequest);

    UserResponse findById(Long id);

    UserResponse update(Long userId, UserRequest userRequest);

    void delete(Long id);
}
