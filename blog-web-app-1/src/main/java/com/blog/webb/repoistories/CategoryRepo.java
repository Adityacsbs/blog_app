package com.blog.webb.repoistories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.webb.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
