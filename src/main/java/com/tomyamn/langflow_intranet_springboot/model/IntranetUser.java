package com.tomyamn.langflow_intranet_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "intranet_user")
public class IntranetUser extends User {
    // Inherits all fields, getters, and setters from User.java
}