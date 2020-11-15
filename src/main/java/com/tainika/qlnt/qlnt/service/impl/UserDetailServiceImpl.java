package com.tainika.qlnt.qlnt.service.impl;

import com.tainika.qlnt.qlnt.model.User;
import com.tainika.qlnt.qlnt.model.UserPrincipal;
import com.tainika.qlnt.qlnt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found! ");
        }

        return new UserPrincipal(user);
    }
}
