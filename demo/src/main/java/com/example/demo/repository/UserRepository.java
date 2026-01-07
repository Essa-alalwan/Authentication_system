package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    // Used during login + token checks
    Optional<AppUser> findByUsername(String username);

    // Helpful for validation during registration
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
