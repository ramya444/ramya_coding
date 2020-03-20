package com.example.security.securitydbexample.models;

import org.springframework.data.mongodb.core.index.Indexed;

public enum ERole {
    ROLE_USER,
    @Indexed(unique=true)
    ROLE_ADMIN,
    @Indexed(unique = true)
    ROLE_MANAGEMENT
}
