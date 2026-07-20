package com.tomyamn.langflow_intranet_springboot.dto;

public class InternetUserLogDTO extends BaseDTO {
    private Long id;
    private Long internetUserId;
    private String remark;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInternetUserId() { return internetUserId; }
    public void setInternetUserId(Long internetUserId) { this.internetUserId = internetUserId; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}