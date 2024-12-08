package com.blog.webb.services.impl;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.webb.entities.Category;
import com.blog.webb.exceptions.ResourceNotFoundException;
import com.blog.webb.payloads.CategoryDto;
import com.blog.webb.repoistories.CategoryRepo;
import com.blog.webb.services.CategorySer;

@Service
public class CategoryServiceimpl implements CategorySer {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.modelMapper.map(categoryDto, Category.class) ;
		
		Category catAdded = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(catAdded, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedcat = this.categoryRepo.save(cat);
		
		
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id",  categoryId));
		
		this.categoryRepo.delete(cat);
		
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new  ResourceNotFoundException("Category", "category id",  categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDto> catDtos = categories.stream().map((cat)-> this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
