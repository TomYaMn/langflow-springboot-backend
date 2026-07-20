package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "internet_user")
public class InternetUser extends User {
    // Inherits all fields, getters, and setters from User.java
}