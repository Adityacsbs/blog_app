package com.blog.webb.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.webb.exceptions.*;
import com.blog.webb.payloads.UserDto;
import com.blog.webb.services.UserSer;
import com.blog.webb.repoistories.*;
import com.blog.webb.entities.*;

@Service
public class UserServiceImpl implements UserSer {
	
	
	@Autowired
	private UserRepo userRepoo;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user =this.doToUser(userDto);
		
	  User savedUser = 	this.userRepoo.save(user);
				
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepoo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," id" ,userId));
		
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setMobile_number(userDto.getMobile_number());
		
		
		User updatedUser = this.userRepoo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		
		return userDto1;
		
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepoo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," id" ,userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		 List<User> users =  this.userRepoo.findAll();
		 
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		 
return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepoo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," id" ,userId));
		
		this.userRepoo.delete(user);
		
		// TODO Auto-generated method stub
 
	}
	
	private User doToUser(UserDto userdto) {
		
		User user = this.modelmapper.map(userdto, User.class) ;
		
		
//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setEmail(userdto.getEmail());
//		user.setAbout(userdto.getAbout());
//		user.setPassword(userdto.getPassword());
//		user.setMobile_number(userdto.getMobile_number());
		
		return user;
		
		
	}
	
	//how model mapper works 
	
	public UserDto userToDto(User user) {
		
		UserDto userDTo =  this.modelmapper.map(user, UserDto.class)  ;
		
//		userDTo.setId(user.getId());
//		userDTo.setName(user.getName());
//		userDTo.setEmail(user.getEmail());
//		userDTo.setAbout(user.getAbout());
//		userDTo.setPassword(user.getPassword());
//		userDTo.setMobile_number(user.getMobile_number());
		
		
		
		
		return userDTo;
		
	}

}
