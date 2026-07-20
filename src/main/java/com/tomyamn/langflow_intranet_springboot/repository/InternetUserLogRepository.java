package com.tomyamn.langflow_intranet_springboot.repository;

import com.tomyamn.langflow_intranet_springboot.model.InternetUserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternetUserLogRepository extends JpaRepository<InternetUserLog, Long> {
}