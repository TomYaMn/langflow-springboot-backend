package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "listener_log")
public class ListenerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "response_body", columnDefinition = "LONGTEXT")
    private String responseBody;

    private String remark;

    @Column(name = "created_by")
    private String createdBy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getResponseBody() { return responseBody; }
    public void setResponseBody(String responseBody) { this.responseBody = responseBody; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}