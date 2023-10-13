package com.springboot.rals.web;

import com.springboot.rals.service.UserService;
import com.springboot.rals.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showRegistrationForm(Model model) {
        // tao new attribute va gui cho ben view
        model.addAttribute("user", new UserRegistrationDto());
        // gui vao trang registration
        return "registration";
    }

    @PostMapping
    public String registerAccount(@ModelAttribute("user")UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
