package com.tomyamn.langflow_intranet_springboot.repository;

import com.tomyamn.langflow_intranet_springboot.model.ListenerLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerLogRepository extends JpaRepository<ListenerLog, Long> {
}