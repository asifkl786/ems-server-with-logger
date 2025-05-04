package com.ems.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}

