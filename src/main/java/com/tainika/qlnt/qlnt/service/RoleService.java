package com.tainika.qlnt.qlnt.service;

import com.google.common.base.Strings;
import com.tainika.qlnt.qlnt.model.Authority;
import com.tainika.qlnt.qlnt.model.Role;
import com.tainika.qlnt.qlnt.repository.AuthorityRepository;
import com.tainika.qlnt.qlnt.repository.RoleRepository;
import com.tainika.qlnt.qlnt.constants.AppUserRole;
import com.tainika.qlnt.qlnt.constants.Message;
import com.tainika.qlnt.qlnt.constants.AppUserPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public MessageResultService<?> findByRoleCode(String code) {
        Role r = roleRepository.findByRoleCode(Strings.nullToEmpty(code));
        try {
            if (r == null) {
                return new MessageResultService<>(Message.ACTION.SEARCH, Message.ALERT.NO_RESULT, null).withFailureResponse();
            }
        } catch (Exception ex) {
            return new MessageResultService<>(Message.ACTION.SEARCH, ex.getMessage(), null).withErrorResponse();
        }
        return new MessageResultService<>(Message.ACTION.SEARCH, r).withSuccessResponse();
    }

    public MessageResultService<?> create(String code) {
        try {
            String c = Strings.isNullOrEmpty(code) ? AppUserRole.GUEST.getCode() : code;

            List<Authority> authorities = AppUserRole.valueOf(c).getPermissions()
                    .stream()
                    .map(AppUserPermission::getPermission)
                    .map(Authority::new)
                    .collect(Collectors.toList());
            List<Authority> lsAuth = authorityRepository.saveAll(authorities);

            if (lsAuth.isEmpty()) {
                return new MessageResultService<>(Message.ACTION.CREATE, "List auth can't be created", null)
                        .withFailureResponse();
            }

            Role r = new Role();
            r.setCode(c);
            r.setAuthorities(lsAuth);
            r.setCreateTime(new Date());
            r.setUpdateTime(new Date());
            roleRepository.save(r);
            return new MessageResultService<>(Message.ACTION.CREATE, r).withSuccessResponse();
        } catch (Exception ex) {
            return new MessageResultService<>(Message.ACTION.CREATE, ex.getMessage(), null).withErrorResponse();
        }
    }
}
