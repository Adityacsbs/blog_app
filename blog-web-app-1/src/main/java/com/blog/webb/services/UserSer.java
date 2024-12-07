package com.blog.webb.services;

import java.util.*;

import com.blog.webb.payloads.UserDto;

public interface UserSer {

	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
