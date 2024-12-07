package com.blog.webb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity  
@Table
@NoArgsConstructor
@Getter
@Setter
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	@Column(name="user_name", nullable= false, length= 100)
	
	private String name;
	
	
	private String email;
	
	
	private String about;
	
	
	private long mobile_number;
	
	
	
	private String password;
	
	
	
}
