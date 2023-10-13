package com.springboot.rals.service;

import com.springboot.rals.model.User;
import com.springboot.rals.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
