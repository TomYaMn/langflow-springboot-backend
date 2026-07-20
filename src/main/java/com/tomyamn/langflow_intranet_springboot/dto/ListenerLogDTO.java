package com.tomyamn.langflow_intranet_springboot.dto;

public class ListenerLogDTO extends BaseDTO {
    private Long id;
    private String responseBody;
    private String remark;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getResponseBody() { return responseBody; }
    public void setResponseBody(String responseBody) { this.responseBody = responseBody; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}