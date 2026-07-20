package com.tomyamn.langflow_intranet_springboot.controller;

import com.tomyamn.langflow_intranet_springboot.dto.UserDTO;
import com.tomyamn.langflow_intranet_springboot.dto.IntranetUserLogDTO;
import com.tomyamn.langflow_intranet_springboot.dto.InternetUserLogDTO;
import com.tomyamn.langflow_intranet_springboot.model.IntranetUser;
import com.tomyamn.langflow_intranet_springboot.model.InternetUser;
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

    // API 2: Get a particular user detail using the UserDTO
    @PostMapping("/detail")
    public ResponseEntity<?> getUserDetail(@RequestBody UserDTO request) {
        Long userId = request.getId(); // Pulled directly from the exact DTO

        return intranetRepo.findById(userId)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> internetRepo.findById(userId)
                        .<ResponseEntity<?>>map(ResponseEntity::ok)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"))); // Fixed the typo here
    }

    // API 5: Update an intranet user action using the IntranetUserLogDTO
    @PostMapping("/intranet/update")
    public ResponseEntity<IntranetUserLog> updateIntranetUserAction(@RequestBody IntranetUserLogDTO request) {
        Long requestedUserId = request.getIntranetUserId(); // Pulled directly from the exact DTO

        // Find the user, or create a brand new one if they don't exist
        IntranetUser user = intranetRepo.findById(requestedUserId).orElseGet(() -> {
            IntranetUser newUser = new IntranetUser();
            newUser.setName("Auto-Created Intranet User");
            newUser.setCreatedBy(request.getCreatedBy());
            return intranetRepo.save(newUser);
        });

        // Create the log attached to the guaranteed-to-exist user
        IntranetUserLog log = new IntranetUserLog();
        log.setIntranetUserId(user.getId());
        log.setRemark(request.getRemark());
        log.setCreatedBy(request.getCreatedBy()); // Automatically handles times due to BaseEntity

        return ResponseEntity.ok(intranetLogRepo.save(log));
    }

    // API 6: Update an internet user action using the InternetUserLogDTO
    @PostMapping("/internet/update")
    public ResponseEntity<InternetUserLog> updateInternetUserAction(@RequestBody InternetUserLogDTO request) {
        Long requestedUserId = request.getInternetUserId(); // Pulled directly from the exact DTO

        // Find the user, or create a brand new one if they don't exist
        InternetUser user = internetRepo.findById(requestedUserId).orElseGet(() -> {
            InternetUser newUser = new InternetUser();
            newUser.setName("Auto-Created Internet User");
            newUser.setCreatedBy(request.getCreatedBy());
            return internetRepo.save(newUser);
        });

        // Create the log attached to the guaranteed-to-exist user
        InternetUserLog log = new InternetUserLog();
        log.setInternetUserId(user.getId());
        log.setRemark(request.getRemark());
        log.setCreatedBy(request.getCreatedBy()); // Automatically handles times due to BaseEntity

        return ResponseEntity.ok(internetLogRepo.save(log));
    }
}