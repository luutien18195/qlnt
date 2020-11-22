package com.tainika.qlnt.qlnt.repository;

import com.tainika.qlnt.qlnt.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String>, RoleRepositoryCustom {
    Role findByCode(String code);
}
