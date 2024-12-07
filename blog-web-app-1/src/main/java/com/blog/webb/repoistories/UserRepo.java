package com.blog.webb.repoistories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.webb.entities.User;

public interface UserRepo extends JpaRepository<User , Integer>{

}
