package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "intranet_user_log")
public class IntranetUserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intranet_user_id", nullable = false)
    private Long intranetUserId;

    private String remark;

    @Column(name = "created_by")
    private String createdBy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIntranetUserId() { return intranetUserId; }
    public void setIntranetUserId(Long intranetUserId) { this.intranetUserId = intranetUserId; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}