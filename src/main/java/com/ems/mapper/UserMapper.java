package com.ems.mapper;

import com.ems.dto.UserDto;
import com.ems.entity.User;

public class UserMapper {
	
	
	 // Convert to Entity	 
	 public static User toEntity(UserDto userDto) {
		 User user = new User();
		user.setName(userDto.getName());
		user.setGender(userDto.getGender());
		user.setMobilenumber(userDto.getMobilenumber());
		 return user; 
	 }
	 
	 
	 // Convert to Dto
	 public static UserDto toDto(User user) { 
		 UserDto userDto = new UserDto();
		 userDto.setName(user.getName());
		 userDto.setGender(user.getGender());
		 userDto.setMobilenumber(user.getMobilenumber());
		 return userDto;
	 }   

}
