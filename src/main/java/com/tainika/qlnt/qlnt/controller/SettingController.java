package com.tainika.qlnt.qlnt.controller;

import com.tainika.qlnt.qlnt.service.MessageResultService;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.service.SettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/settings_service")
public class SettingController {
    @Autowired
    SettingService settingService;

    @GetMapping(path = "/ss0002")
    public ResponseEntity<?> findAllUser() {
        MessageResultService<List<User>> messageResultService = settingService.getAllUser();
        if (messageResultService.getItem().isEmpty()) {
            return new ResponseEntity<>(messageResultService.getResponseMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(messageResultService.getItem(), HttpStatus.OK);
    }
}
