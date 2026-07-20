package com.tomyamn.langflow_intranet_springboot.dto;

public class BaseDTO {
    private String createdBy;
    private String updatedBy;

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
}