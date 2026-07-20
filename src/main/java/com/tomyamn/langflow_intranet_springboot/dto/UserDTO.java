package com.tomyamn.langflow_intranet_springboot.dto;

public class UserDTO extends BaseDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNo;
    private String nric;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getNric() { return nric; }
    public void setNric(String nric) { this.nric = nric; }
}