package com.ems.service.Imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.UserDto;
import com.ems.entity.User;
import com.ems.mapper.UserMapper;
import com.ems.repository.UserRepository;
import com.ems.service.UserService;


@Service
public class UserServiceImple implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImple.class);
	
	@Autowired
	UserRepository userRepository;

	
	// This method to create user 
	@Override
	public UserDto addUser(UserDto userDto) {
		logger.info("create User Whose Name : {}", userDto.getName());
		User user = UserMapper.toEntity(userDto);
		User savedUser = userRepository.save(user);
		logger.info("User Successfully Saved Whose Name : {}", userDto.getName());
		return UserMapper.toDto(savedUser);
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
