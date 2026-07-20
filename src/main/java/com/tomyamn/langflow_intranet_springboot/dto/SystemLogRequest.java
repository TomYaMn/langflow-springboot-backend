package com.tomyamn.langflow_intranet_springboot.dto;

public class SystemLogRequest {
    private String payloadBody; // Maps to response_body or request_body
    private String remark;
    private String createdBy;

    // Getters and Setters
    public String getPayloadBody() { return payloadBody; }
    public void setPayloadBody(String payloadBody) { this.payloadBody = payloadBody; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}