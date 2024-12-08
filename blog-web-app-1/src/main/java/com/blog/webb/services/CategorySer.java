package com.blog.webb.services;

import java.util.*;

import com.blog.webb.payloads.CategoryDto;

public interface CategorySer {
	
	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	
	
	//update
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

	
	//delete
	 void deleteCategory(Integer categoryId);

	
	
	
	//get
	 CategoryDto getCategory(Integer categoryId);

	
	//Get all
	 List<CategoryDto> getCategories();
	

}
