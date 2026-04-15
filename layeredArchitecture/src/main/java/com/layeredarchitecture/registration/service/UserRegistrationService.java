package com.layeredarchitecture.registration.service;

import com.layeredarchitecture.registration.dto.UserRegistrationRequest;
import com.layeredarchitecture.registration.entity.UserRegistration;
import com.layeredarchitecture.registration.exception.UserAlreadyExistsException;
import com.layeredarchitecture.registration.repository.UserRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
 private final UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }
    public void registerUser(UserRegistrationRequest  userRegistrationRequest) {
        userRegistrationRepository.findByEmail(userRegistrationRequest.getEmail()).ifPresent(userRegistration ->{
            throw new UserAlreadyExistsException("Email Already Exists");
        });
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.setName(userRegistrationRequest.getName());
        userRegistration.setEmail(userRegistrationRequest.getName());
        userRegistrationRepository.save(userRegistration);
    }
}
