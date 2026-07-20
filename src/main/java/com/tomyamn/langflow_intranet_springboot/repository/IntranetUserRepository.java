package com.tomyamn.langflow_intranet_springboot.repository;

import com.tomyamn.langflow_intranet_springboot.model.IntranetUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntranetUserRepository extends JpaRepository<IntranetUser, Long> {
}