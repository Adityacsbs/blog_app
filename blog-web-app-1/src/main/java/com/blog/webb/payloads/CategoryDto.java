package com.blog.webb.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter


public class CategoryDto {

	
	
	
	private Integer categoryId;
	
	@NotEmpty
	private String CategoryTitle;
	@NotEmpty(message="you have to write something in this ")
	private String CategoryDescription;

	
	
	
	
}
