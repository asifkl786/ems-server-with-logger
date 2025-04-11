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

import com.ems.dto.UserDto;
import com.ems.service.UserService;

import lombok.AllArgsConstructor;

//@CrossOrigin("*")
@CrossOrigin(origins = "https://ems-curd.netlify.app")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	
	// Build REST API add user
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		logger.info("Received request to create User Whose Name : {}", userDto.getName());
		UserDto savedUser = userService.addUser(userDto);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}

}
