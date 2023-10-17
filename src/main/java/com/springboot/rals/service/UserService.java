package com.springboot.rals.service;

import com.springboot.rals.model.User;
import com.springboot.rals.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService{
    User save(UserRegistrationDto userRegistrationDto);
    User findUserByEmail(String email);
    List<User> findAllUsers();
    User findUserByID(Long id);
}
