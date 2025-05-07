package com.ems.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.AuthenticationRequest;
import com.ems.dto.AuthenticationResponse;
import com.ems.dto.RegisterRequest;
import com.ems.service.Imple.AuthenticationService;


// Purpose of This class Handles /register, /login APIs
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authService;

   /* 
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    	logger.info("Received request to Registered User with Name:: {}", request.getUsername());
        AuthenticationResponse response = authService.register(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    } */
    /*
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(authService.register(request));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    } */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
    	logger.info("Received request to Registered User with Name:: {}", request.getUsername());
    	 authService.register(request);
    	return new ResponseEntity<>("User Successfully Registerd",HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
    	logger.info("Received request to Login User with email:: {}", request.getEmail());
        AuthenticationResponse response = authService.login(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}

