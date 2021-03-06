package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.common.Result;
import com.tainika.qlnt.qlnt.model.User;

public interface RegistrationService {
    User createNewUser(User newUser);
    Result<?> signUp(User user);
}
