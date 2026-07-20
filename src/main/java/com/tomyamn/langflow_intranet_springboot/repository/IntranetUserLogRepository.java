package com.tomyamn.langflow_intranet_springboot.repository;

import com.tomyamn.langflow_intranet_springboot.model.IntranetUserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntranetUserLogRepository extends JpaRepository<IntranetUserLog, Long> {
}