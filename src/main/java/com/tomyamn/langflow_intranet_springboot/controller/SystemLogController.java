package com.tomyamn.langflow_intranet_springboot.controller;

import com.tomyamn.langflow_intranet_springboot.dto.SystemLogRequest;
import com.tomyamn.langflow_intranet_springboot.model.ListenerLog;
import com.tomyamn.langflow_intranet_springboot.model.PublisherLog;
import com.tomyamn.langflow_intranet_springboot.repository.ListenerLogRepository;
import com.tomyamn.langflow_intranet_springboot.repository.PublisherLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class SystemLogController {

    @Autowired private ListenerLogRepository listenerLogRepository;
    @Autowired private PublisherLogRepository publisherLogRepository;

    // API 7: Update the listener log based on the return response body
    @PostMapping("/listener")
    public ResponseEntity<ListenerLog> createListenerLog(@RequestBody SystemLogRequest request) {
        ListenerLog log = new ListenerLog();
        log.setResponseBody(request.getPayloadBody());
        log.setRemark(request.getRemark());
        log.setCreatedBy(request.getCreatedBy());
        return ResponseEntity.ok(listenerLogRepository.save(log));
    }

    // API 8: Update the publisher log based on the request body to be sent
    @PostMapping("/publisher")
    public ResponseEntity<PublisherLog> createPublisherLog(@RequestBody SystemLogRequest request) {
        PublisherLog log = new PublisherLog();
        log.setRequestBody(request.getPayloadBody());
        log.setRemark(request.getRemark());
        log.setCreatedBy(request.getCreatedBy());
        return ResponseEntity.ok(publisherLogRepository.save(log));
    }
}