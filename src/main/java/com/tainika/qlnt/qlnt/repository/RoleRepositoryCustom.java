package com.tainika.qlnt.qlnt.repository;

import com.tainika.qlnt.qlnt.model.Role;

import java.util.List;

public interface RoleRepositoryCustom {
    Role findByRoleCode(String code);
}
