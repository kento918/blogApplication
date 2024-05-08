package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	@Id
	int id;
	String name;
	String description;
	int parent_id;
	LocalDateTime created_at;
	LocalDateTime updated_at;
	int order;
	String image;
}
