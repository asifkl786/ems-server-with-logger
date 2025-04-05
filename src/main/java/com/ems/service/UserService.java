package com.ems.service;

import java.util.List;

import com.ems.dto.UserDto;

public interface UserService {
	
	UserDto addUser(UserDto userDto);
	UserDto getUserById(Long id);
	List<UserDto> getAllUser();
	UserDto updateUser(Long id, UserDto userDto);
	List<UserDto> searchUser(String query);
	Void deleteUser(Long id);

}
