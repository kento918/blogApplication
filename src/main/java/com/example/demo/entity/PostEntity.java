package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PostEntity {
	@Id
	int id;
	String title;
	String body;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
	int authorId;
	int categoryId;
	boolean published;
	String slug;
	
	public boolean isNull() {
		return this.title == null || this.body == null;
	}
}