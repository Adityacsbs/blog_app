package com.blog.webb.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blog.webb.services.UserSer;

import jakarta.validation.Valid;

import com.blog.webb.payloads.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserSer userservice;
	
	//post -create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createdUserDto = this.userservice.createUser(userDto);
		
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	//put - update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		
	UserDto updatedUser = 	this.userservice.updateUser(userDto, uid);
	
		return ResponseEntity.ok(updatedUser);
		
	}
	
	// Delete - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResp> deleteUser(@PathVariable("userId") Integer uid){
		
		   this.userservice.deleteUser(uid);
		
	//	return  new ResponseEntity(Map.of("message","user deleted successfully"),HttpStatus .OK);
		//return ResponseEntity.ok(Map.of("message","user deleted successfully"));
		   
			return new ResponseEntity(new ApiResp("User deleted Succesfully",true), HttpStatus .OK);

	}
	
	//GET - user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>getAllUsers() {
		
		
		return ResponseEntity.ok(this.userservice.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto>getSingleUser(@PathVariable Integer userId) {
		
		
		return ResponseEntity.ok(this.userservice.getUserById(userId));
	}
	
	
	
	
}


