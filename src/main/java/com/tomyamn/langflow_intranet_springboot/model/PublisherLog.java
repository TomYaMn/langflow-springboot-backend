package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "publisher_log")
public class PublisherLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_body", columnDefinition = "LONGTEXT")
    private String requestBody;

    private String remark;

    @Column(name = "created_by")
    private String createdBy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRequestBody() { return requestBody; }
    public void setRequestBody(String requestBody) { this.requestBody = requestBody; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}