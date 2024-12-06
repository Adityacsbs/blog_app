package com.blog.webb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity  //@Entity(name="xyz") to change the entity name
@Table //@Table(name="users") //yeah automatically table banata hai User name par apan ne name change kr diya hai users
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	@Column(name="user_name", nullable= false, length= 100)
	private String name;
	
	
	@SuppressWarnings("unused")
	private String email;
	
	
	private String about;
	
	
	
	private String password;
	
	
	
}
