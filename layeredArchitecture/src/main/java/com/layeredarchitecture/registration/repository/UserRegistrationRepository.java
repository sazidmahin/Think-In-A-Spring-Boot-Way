package com.layeredarchitecture.registration.repository;

import com.layeredarchitecture.registration.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRegistrationRepository  extends JpaRepository<UserRegistration, UUID> {
    Optional<UserRegistration>findByEmail(String email);
}
