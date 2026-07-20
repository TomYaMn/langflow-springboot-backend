package com.tomyamn.langflow_intranet_springboot.repository;

import com.tomyamn.langflow_intranet_springboot.model.PublisherLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherLogRepository extends JpaRepository<PublisherLog, Long> {
}