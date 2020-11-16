package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import com.tainika.qlnt.qlnt.ultil.Message;
import com.tainika.qlnt.qlnt.ultil.StatusConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordService passwordService;

    public User createNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    public MessageResultService<?> signUp(User user) {
        try {
            boolean isExistedUser = userRepository.isExistedUserName(user.getUserName());
            if (isExistedUser) {
                return new MessageResultService<>(Message.ACTION.SIGN_UP, Message.ALERT.USER_EXISTED, null).widthFailureResponse();
            }

            boolean isExistedEmail = userRepository.isExistedEmail(user.getEmail());
            if (isExistedEmail) {
                return new MessageResultService<>(Message.ACTION.SIGN_UP, Message.ALERT.EMAIL_EXISTED, null).widthFailureResponse();
            }

            user.setPassword(passwordService.getEncryptedPassword(user.getPassword()));
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setStatus(StatusConstant.USER.TEMPORARY.getCode());
            User rUser = userRepository.save(user);
            return new MessageResultService<>(Message.ACTION.SIGN_UP, rUser).widthSuccessResponse();
        } catch (Exception err) {
            return new MessageResultService<>(Message.ACTION.SIGN_UP, err.getMessage(), null).widthErrorResponse();
        }
    }
}
