package com.tainika.qlnt.qlnt.controller;

import com.tainika.qlnt.qlnt.common.Result;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/registration_service")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/rs0001")
    public ResponseEntity<?> signup(@RequestBody User newUser){
        Result<?> result = registrationService.signUp(newUser);
        if(result.getItem()==null) {
            return new ResponseEntity<>(result.getResponseMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(result.getItem(), HttpStatus.CREATED);
    }
}
