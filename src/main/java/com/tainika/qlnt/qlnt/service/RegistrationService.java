package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.constants.AppUserRole;
import com.tainika.qlnt.qlnt.model.Role;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import com.tainika.qlnt.qlnt.constants.Message;
import com.tainika.qlnt.qlnt.constants.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleService roleService;

    public User createNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    public MessageResultService<?> signUp(User user) {
        try {
            boolean isExistedUser = userRepository.isExistedUserName(user.getUserName());
            if (isExistedUser) {
                return new MessageResultService<>(Message.ACTION.SIGN_UP, Message.ALERT.USER_EXISTED, null)
                        .widthFailureResponse();
            }

            boolean isExistedEmail = userRepository.isExistedEmail(user.getEmail());
            if (isExistedEmail) {
                return new MessageResultService<>(Message.ACTION.SIGN_UP, Message.ALERT.EMAIL_EXISTED, null)
                        .widthFailureResponse();
            }

            user.setPassword(encoder.encode(user.getPassword()));
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setStatus(Status.USER.TEMPORARY.getCode());

            MessageResultService<?> oldRole = roleService.findByRoleCode(AppUserRole.GUEST.getCode());
            if (oldRole.getStatus().equals(Status.COMMON.ERROR)) {
                return new MessageResultService<>(Message.ACTION.SIGN_UP, oldRole.getResponseMessage() ,null)
                        .widthFailureResponse();
            } else if (oldRole.getStatus().equals(Status.COMMON.FAILURE)) {
                MessageResultService<?> newRole = roleService.create(AppUserRole.GUEST.getCode());

                if (newRole.getStatus().equals(Status.COMMON.ERROR)) {
                    return new MessageResultService<>(Message.ACTION.SIGN_UP, newRole.getResponseMessage() ,null)
                            .widthFailureResponse();
                } else {
                    Role r = (Role) newRole.getItem();
                    user.setRole(r);
                }
            } else if (oldRole.getStatus().equals(Status.COMMON.SUCCESS)) {
                Role r = (Role) oldRole.getItem();
                if (r != null) {
                    user.setRole(r);
                }
            }

            User rUser = userRepository.save(user);
            return new MessageResultService<>(Message.ACTION.SIGN_UP, rUser).widthSuccessResponse();
        } catch (Exception err) {
            return new MessageResultService<>(Message.ACTION.SIGN_UP, err.getMessage(), null)
                    .widthErrorResponse();
        }
    }
}
