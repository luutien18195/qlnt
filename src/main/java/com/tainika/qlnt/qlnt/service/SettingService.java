package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import com.tainika.qlnt.qlnt.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingService {
    @Autowired
    private UserRepository userRepository;

    public MessageResultService<List<User>> getAllUser() {
        try{
            return new MessageResultService<>(Message.ACTION.GET_ALL, userRepository.findAll()).widthSuccessResponse();
        } catch (Exception err) {
            return new MessageResultService<List<User>>(Message.ACTION.GET_ALL, err.getMessage(), new ArrayList<>()).widthErrorResponse();
        }
    }
}
