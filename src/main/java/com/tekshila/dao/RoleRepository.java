package com.tekshila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tekshila.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
