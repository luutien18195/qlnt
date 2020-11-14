package com.tainika.qlnt.qlnt.service.impl;

import com.tainika.qlnt.qlnt.common.Result;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import com.tainika.qlnt.qlnt.service.SettingService;
import com.tainika.qlnt.qlnt.ultil.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Result<List<User>> getAllUser() {
        try{
            return new Result<>(Message.ACTION.GET_ALL, userRepository.findAll()).success();
        } catch (Exception err) {
            return new Result<List<User>>(Message.ACTION.GET_ALL, err.getMessage(), new ArrayList<>()).error();
        }
    }
}
