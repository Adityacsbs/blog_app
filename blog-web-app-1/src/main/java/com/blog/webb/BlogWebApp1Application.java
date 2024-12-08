package com.blog.webb;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
public class BlogWebApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(BlogWebApp1Application.class, args);
		//this comment is for when i am try again to push the updated code in git
	}
		
	
	
		@Bean
		public ModelMapper modelmapper() {
			
			
			return new ModelMapper();
		}
		
		
		
		
	

}
