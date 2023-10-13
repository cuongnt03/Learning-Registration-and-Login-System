package com.springboot.rals.service;

import com.springboot.rals.model.User;
import com.springboot.rals.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public interface UserService{
    User save(UserRegistrationDto userRegistrationDto);
    User findUserByEmail(String email);
}
