package com.tainika.qlnt.qlnt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/registration/")
public class RegistrationController {

    public ResponseEntity<?> signup(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
