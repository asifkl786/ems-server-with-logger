package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
