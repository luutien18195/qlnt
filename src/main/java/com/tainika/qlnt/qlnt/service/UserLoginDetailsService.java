package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.model.UserLoginDetails;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that userName");
        }
        return new UserLoginDetails(user);
    }
}
