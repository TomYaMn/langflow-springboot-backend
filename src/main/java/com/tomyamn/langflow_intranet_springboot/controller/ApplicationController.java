package com.tomyamn.langflow_intranet_springboot.controller;

import com.tomyamn.langflow_intranet_springboot.dto.ApplicationDetailRequest;
import com.tomyamn.langflow_intranet_springboot.model.Application;
import com.tomyamn.langflow_intranet_springboot.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    // API 3: Get all application details
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationRepository.findAll());
    }

    // API 4: Get a particular application detail by attaching an application ID
    @PostMapping("/detail")
    public ResponseEntity<Application> getApplicationDetail(@RequestBody ApplicationDetailRequest request) {
        String appIdStr = request.getApplicationId();
        return applicationRepository.findByApplicationNo(appIdStr)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    try {
                        return applicationRepository.findById(Long.parseLong(appIdStr))
                                .map(ResponseEntity::ok)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "App not found"));
                    } catch (NumberFormatException e) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "App not found");
                    }
                });
    }
}