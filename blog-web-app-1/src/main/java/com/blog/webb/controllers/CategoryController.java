package com.blog.webb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.webb.payloads.ApiResp;
import com.blog.webb.payloads.CategoryDto;
import com.blog.webb.services.CategorySer;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
	
	@Autowired
	private CategorySer categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categorydto){
		
		CategoryDto createCategory = this.categoryService.createCategory(categorydto);
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	//update
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categorydto,@PathVariable Integer catId){
		
		CategoryDto updateCategory = this.categoryService.updateCategory(categorydto,catId);
		
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	
	
	
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResp> deleteCategory(@PathVariable Integer catId){
		
		 this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResp>(new ApiResp("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	
	
	//get
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		
		 CategoryDto categoryDto = this.categoryService.getCategory(catId);
		
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
		
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	

}
