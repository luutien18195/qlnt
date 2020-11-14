package com.tainika.qlnt.qlnt.controller;

import com.tainika.qlnt.qlnt.common.Result;
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
        Result<List<User>> result = settingService.getAllUser();
        if (result.getItem().isEmpty()) {
            return new ResponseEntity<>(result.getResponseMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(result.getItem(), HttpStatus.OK);
    }
}
