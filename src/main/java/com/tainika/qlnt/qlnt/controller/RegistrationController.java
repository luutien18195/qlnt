package com.tainika.qlnt.qlnt.controller;

import com.tainika.qlnt.qlnt.service.RegistrationService;
import com.tainika.qlnt.qlnt.service.MessageResultService;
import com.tainika.qlnt.qlnt.model.User;
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
        MessageResultService<?> messageResultService = registrationService.signUp(newUser);
        if(messageResultService.getItem()==null) {
            return new ResponseEntity<>(messageResultService.getResponseMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(messageResultService.getItem(), HttpStatus.CREATED);
    }
}
