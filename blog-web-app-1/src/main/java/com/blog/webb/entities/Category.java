package com.blog.webb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="categories")
@NoArgsConstructor
@Setter
@Getter

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(name="title", length=100, nullable= false)
	private String CategoryTitle;
	
	@Column(name="description")
	private String CategoryDescription;

}
