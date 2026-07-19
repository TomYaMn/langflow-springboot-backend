package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appName;
    private String description;

    // Constructors, Getters, and Setters
    public Application() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}