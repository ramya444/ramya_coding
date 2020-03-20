package com.example.security.securitydbexample.repository;

import com.example.security.securitydbexample.models.ERole;
import com.example.security.securitydbexample.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
    Optional <Role> findByName(ERole name);
}
