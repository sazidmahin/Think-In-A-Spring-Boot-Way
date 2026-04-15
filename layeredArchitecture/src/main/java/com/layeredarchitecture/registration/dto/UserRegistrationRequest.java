package com.layeredarchitecture.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserRegistrationRequest {
    public String email;
    public String name;
}
