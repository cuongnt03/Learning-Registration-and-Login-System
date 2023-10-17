package com.springboot.rals.controller;

import com.springboot.rals.model.User;
import com.springboot.rals.service.UserService;
import com.springboot.rals.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        // tao new attribute va gui cho ben view
        model.addAttribute("user", new UserRegistrationDto());
        // gui vao trang registration
        return "registration";
    }
    @PostMapping("/registration/save")
    public String registerAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto, BindingResult result, Model model) {
        User existing = userService.findUserByEmail(userRegistrationDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userRegistrationDto);
            return "registration";
        }
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/users/view/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.findUserByID(id));
        return "view_user";
    }
}
