package com.tainika.qlnt.qlnt.controller;

import com.tainika.qlnt.qlnt.service.RegistrationService;
import com.tainika.qlnt.qlnt.service.MessageResultService;
import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.constants.Status;
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
        MessageResultService<?> msResult = registrationService.signUp(newUser);
        if(msResult.getStatus().equals(Status.COMMON.FAILURE)
        || msResult.getStatus().equals(Status.COMMON.ERROR)) {
            return new ResponseEntity<>(msResult.getResponseMessage(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(msResult.getItem(), HttpStatus.CREATED);
    }
}
