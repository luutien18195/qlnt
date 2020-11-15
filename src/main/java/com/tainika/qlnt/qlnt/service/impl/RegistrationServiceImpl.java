package com.tainika.qlnt.qlnt.service.impl;

import com.tainika.qlnt.qlnt.common.Result;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import com.tainika.qlnt.qlnt.service.RegistrationService;
import com.tainika.qlnt.qlnt.ultil.Message;
import com.tainika.qlnt.qlnt.ultil.StatusConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public Result<?> signUp(User user) {
        try {
            boolean isExistedUser = userRepository.checkUserNameAndIdentityNumber(user.getUserName(), user.getIdentityNumber());
            if (!isExistedUser) {
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                user.setStatus(StatusConstant.USER.TEMPORARY.getCode());
                User rUser = userRepository.save(user);
                return new Result<>(Message.ACTION.SIGN_UP, rUser).success();
            }
        } catch (Exception err) {
            return new Result<>(Message.ACTION.SIGN_UP, err.getMessage(), null).error();
        }
        return new Result<>(Message.ACTION.SIGN_UP, Message.ALERT.USER_EXISTED, null).failure();
    }
}
