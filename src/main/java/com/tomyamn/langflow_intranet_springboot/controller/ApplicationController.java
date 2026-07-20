package com.tomyamn.langflow_intranet_springboot.controller;

import com.tomyamn.langflow_intranet_springboot.dto.ApplicationDTO;
import com.tomyamn.langflow_intranet_springboot.model.Application;
import com.tomyamn.langflow_intranet_springboot.model.InternetUser;
import com.tomyamn.langflow_intranet_springboot.repository.ApplicationRepository;
import com.tomyamn.langflow_intranet_springboot.repository.InternetUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private InternetUserRepository internetUserRepository;

    // API 3: Get all application details
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationRepository.findAll());
    }

    // API 4: Get a particular application detail using ApplicationDTO
    @PostMapping("/detail")
    public ResponseEntity<Application> getApplicationDetail(@RequestBody ApplicationDTO request) {

        // 1. Try to find the application by applicationNo (if provided in payload)
        if (request.getApplicationNo() != null) {
            Optional<Application> appByNo = applicationRepository.findByApplicationNo(request.getApplicationNo());
            if (appByNo.isPresent()) {
                return ResponseEntity.ok(appByNo.get());
            }
        }

        // 2. Try to find by database ID (if provided in payload)
        if (request.getId() != null) {
            Optional<Application> appById = applicationRepository.findById(request.getId());
            if (appById.isPresent()) {
                return ResponseEntity.ok(appById.get());
            }
        }

        // 3. If not found anywhere, auto-create a new Application

        // Step A: Ensure a fallback user exists
        InternetUser defaultUser = internetUserRepository.findById(1L).orElseGet(() -> {
            InternetUser newUser = new InternetUser();
            newUser.setName("System Fallback User");
            newUser.setCreatedBy(request.getCreatedBy() != null ? request.getCreatedBy() : "System");
            return internetUserRepository.save(newUser);
        });

        // Step B: Build and save the new Application pulling exact fields from DTO
        Application newApp = new Application();

        // Fallback to a default if they didn't provide an applicationNo in the request
        newApp.setApplicationNo(request.getApplicationNo() != null ? request.getApplicationNo() : "APP-AUTO-GEN");
        newApp.setSubmittedByInternetUserId(defaultUser.getId());

        // Fallback to 0 (Pending) if they didn't provide a status
        newApp.setStatus(request.getStatus() != null ? request.getStatus() : 0);

        // Use the common DTO fields
        newApp.setCreatedBy(request.getCreatedBy());

        return ResponseEntity.ok(applicationRepository.save(newApp));
    }
}