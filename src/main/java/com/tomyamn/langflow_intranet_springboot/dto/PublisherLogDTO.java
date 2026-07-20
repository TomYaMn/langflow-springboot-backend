package com.tomyamn.langflow_intranet_springboot.dto;

public class PublisherLogDTO extends BaseDTO {
    private Long id;
    private String requestBody;
    private String remark;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRequestBody() { return requestBody; }
    public void setRequestBody(String requestBody) { this.requestBody = requestBody; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}