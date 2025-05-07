package com.ems.dto;

import lombok.Data;


// Purpose of This class Payloads for APIs
@Data
public class RegisterRequest  {
    private String username;
    private String email;
    private String password;
}
