package com.tomyamn.langflow_intranet_springboot.controller;

import com.tomyamn.langflow_intranet_springboot.dto.IdRequest;
import com.tomyamn.langflow_intranet_springboot.dto.UserUpdateRequest;
import com.tomyamn.langflow_intranet_springboot.model.User;
import com.tomyamn.langflow_intranet_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 1. GET API to get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. POST API to attach a user id to get a particular user detail
    @PostMapping("/detail")
    public User getUserDetail(@RequestBody IdRequest request) {
        return userRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // 5. POST API to update a user action in the DB
    @PostMapping("/update")
    public User updateUserAction(@RequestBody UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.setAction(request.getAction());
        return userRepository.save(user);
    }
}