package com.tomyamn.langflow_intranet_springboot.dto;

public class IntranetUserLogDTO extends BaseDTO {
    private Long id;
    private Long intranetUserId;
    private String remark;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIntranetUserId() { return intranetUserId; }
    public void setIntranetUserId(Long intranetUserId) { this.intranetUserId = intranetUserId; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}