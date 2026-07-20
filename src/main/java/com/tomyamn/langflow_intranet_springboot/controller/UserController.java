package com.tomyamn.langflow_intranet_springboot.controller;

import com.tomyamn.langflow_intranet_springboot.dto.UserDetailRequest;
import com.tomyamn.langflow_intranet_springboot.dto.LogActionRequest;
import com.tomyamn.langflow_intranet_springboot.model.IntranetUserLog;
import com.tomyamn.langflow_intranet_springboot.model.InternetUserLog;
import com.tomyamn.langflow_intranet_springboot.repository.InternetUserRepository;
import com.tomyamn.langflow_intranet_springboot.repository.IntranetUserRepository;
import com.tomyamn.langflow_intranet_springboot.repository.IntranetUserLogRepository;
import com.tomyamn.langflow_intranet_springboot.repository.InternetUserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired private IntranetUserRepository intranetRepo;
    @Autowired private InternetUserRepository internetRepo;
    @Autowired private IntranetUserLogRepository intranetLogRepo;
    @Autowired private InternetUserLogRepository internetLogRepo;

    // API 1: Get all users in the system
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        Map<String, Object> response = new HashMap<>();
        response.put("intranetUsers", intranetRepo.findAll());
        response.put("internetUsers", internetRepo.findAll());
        return ResponseEntity.ok(response);
    }

    // API 2: Get a particular user detail by attaching a user ID
    @PostMapping("/detail")
    public ResponseEntity<?> getUserDetail(@RequestBody UserDetailRequest request) {
        Long userId = Long.parseLong(request.getUserId());
        return intranetRepo.findById(userId)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> internetRepo.findById(userId)
                        .<ResponseEntity<?>>map(ResponseEntity::ok)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
    }

    // API 5: Update an intranet user action/information (Creates a log entry)
    @PostMapping("/intranet/update")
    public ResponseEntity<IntranetUserLog> updateIntranetUserAction(@RequestBody LogActionRequest request) {
        Long userId = Long.parseLong(request.getUserId());
        intranetRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Intranet user not found"));

        IntranetUserLog log = new IntranetUserLog();
        log.setIntranetUserId(userId);
        log.setRemark(request.getRemark());
        log.setCreatedBy(request.getCreatedBy());
        return ResponseEntity.ok(intranetLogRepo.save(log));
    }

    // API 6: Update an internet user action/information (Creates a log entry)
    @PostMapping("/internet/update")
    public ResponseEntity<InternetUserLog> updateInternetUserAction(@RequestBody LogActionRequest request) {
        Long userId = Long.parseLong(request.getUserId());
        internetRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Internet user not found"));

        InternetUserLog log = new InternetUserLog();
        log.setInternetUserId(userId);
        log.setRemark(request.getRemark());
        log.setCreatedBy(request.getCreatedBy());
        return ResponseEntity.ok(internetLogRepo.save(log));
    }
}