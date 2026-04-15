package com.layeredarchitecture.registration.controller;

import com.layeredarchitecture.registration.dto.UserRegistrationRequest;
import com.layeredarchitecture.registration.service.UserRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;
    public UserRegistrationController(UserRegistrationService userRegistrationService)
    {
        this.userRegistrationService=userRegistrationService;
    }
    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationRequest  userRegistrationRequest)
    {
        userRegistrationService.registerUser(userRegistrationRequest);
        return "User Registered Successfully";
    }
}
