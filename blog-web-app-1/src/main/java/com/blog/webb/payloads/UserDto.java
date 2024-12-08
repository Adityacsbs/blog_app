package com.blog.webb.payloads;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message= "Name Should be greater than 4 words")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty(message="email should be in correct format")
	private String about;
	
	
	private long mobile_number;
	
	@NotEmpty
	@Size(min=6,max=12,message="message should be more than 6 character")
	private String password;



}

	
	
	
	
	

		


