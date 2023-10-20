package com.example.msrelations.controller;

import com.example.msrelations.dto.request.UserRequest;
import com.example.msrelations.dto.response.UserResponse;
import com.example.msrelations.service.Impl.UserServiceImpl;
import com.example.msrelations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users/v1")
public class UserController {

    private final UserService userService;

    @GetMapping
   public ResponseEntity<List<UserResponse>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);

    }
   @PutMapping("/{id}")
   public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserRequest userRequest) {
       return new ResponseEntity<>(userService.update(id, userRequest), HttpStatus.OK);

   }
   @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
   }


}
