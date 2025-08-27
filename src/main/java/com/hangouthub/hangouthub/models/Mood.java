package com.hangouthub.hangouthub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// using @Getter and @Setter for creating getter setter methods automatically
@Entity
@Getter
@Setter
public class Mood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	public Mood() {	}
	
//	public Long getId() {
//		return id;
//	}
//	public String getName() {
//		return name;
//	}
//	public String getDescription(){
//		return description;
//	}
//	public void setId(Long Id) {
//		this.id=Id;
//	}
//	public void setName(String name) {
//		this.name=name;
//	}
//	public void setDesciption(String description){
//		this.description=description;
//	}
}
