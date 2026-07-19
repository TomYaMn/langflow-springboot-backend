package com.tomyamn.langflow_intranet_springboot.dto;

public class UserUpdateRequest {
    private Long id;
    private String action;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
}