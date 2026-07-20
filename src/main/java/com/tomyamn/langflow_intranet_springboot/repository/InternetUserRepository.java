package com.tomyamn.langflow_intranet_springboot.repository;

import com.tomyamn.langflow_intranet_springboot.model.InternetUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternetUserRepository extends JpaRepository<InternetUser, Long> {
}