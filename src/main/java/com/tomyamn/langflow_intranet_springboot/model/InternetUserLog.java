package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "internet_user_log")
public class InternetUserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "internet_user_id", nullable = false)
    private Long internetUserId;

    private String remark;

    @Column(name = "created_by")
    private String createdBy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInternetUserId() { return internetUserId; }
    public void setInternetUserId(Long internetUserId) { this.internetUserId = internetUserId; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}