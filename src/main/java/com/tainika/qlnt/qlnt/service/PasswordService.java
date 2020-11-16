package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    @Autowired
    private UserRepository userRepository;

    public String getEncryptedPassword(String pw) {
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    }

    public boolean matched(String candidate, String hashed) {
        return BCrypt.checkpw(candidate, hashed);
    }
}
