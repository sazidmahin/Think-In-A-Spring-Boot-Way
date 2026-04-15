package com.layeredarchitecture.registration.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistration {
    @Id
    @UuidGenerator
    private String id;

    private String name;
    private String email;
}
