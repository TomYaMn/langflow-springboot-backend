package com.tomyamn.langflow_intranet_springboot.dto;

public class UserUpdateRequest {
    private String userId;
    private String action;
    private String status;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}