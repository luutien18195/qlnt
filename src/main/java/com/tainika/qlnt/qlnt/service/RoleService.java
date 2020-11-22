package com.tainika.qlnt.qlnt.service;

import com.google.common.base.Strings;
import com.tainika.qlnt.qlnt.model.Authority;
import com.tainika.qlnt.qlnt.model.Role;
import com.tainika.qlnt.qlnt.repository.RoleRepository;
import com.tainika.qlnt.qlnt.constants.AppUserRole;
import com.tainika.qlnt.qlnt.constants.Message;
import com.tainika.qlnt.qlnt.constants.AppUserPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public MessageResultService<?> findByRoleCode(String code) {
        Role r = roleRepository.findByRoleCode(Strings.nullToEmpty(code));
        try {
            if (r == null) {
                return new MessageResultService<>(Message.ACTION.SEARCH, Message.ALERT.NO_RESULT, null).widthFailureResponse();
            }
        } catch (Exception ex) {
            return new MessageResultService<>(Message.ACTION.SEARCH, ex.getMessage(), null).widthErrorResponse();
        }
        return new MessageResultService<>(Message.ACTION.SEARCH, r).widthSuccessResponse();
    }

    public MessageResultService<?> create(String code) {
        try {
            Role r = new Role();
            String c = Strings.isNullOrEmpty(code) ? AppUserRole.GUEST.getCode() : code;
            r.setCode(c);
            r.setAuthorities(AppUserRole.valueOf(c).getPermissions()
                    .stream()
                    .map(AppUserPermission::getPermission)
                    .map(Authority::new)
                    .collect(Collectors.toList()));
            r.setCreateTime(new Date());
            r.setUpdateTime(new Date());
            roleRepository.save(r);
            return new MessageResultService<>(Message.ACTION.CREATE, r).widthSuccessResponse();
        } catch (Exception ex) {
            return new MessageResultService<>(Message.ACTION.CREATE, ex.getMessage(), null).widthErrorResponse();
        }
    }
}
