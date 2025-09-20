package com.hangouthub.hangouthub.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String pswd;
    private String cpswd;
	
	// 🔹 New fields for forgot password
		@Column(unique = true)
		private String resetToken;
	
		private LocalDateTime tokenExpiry;

	public User() {	}
	 
//	public Long getId() {
//		return id;
//	}
//	public String getName() {
//		return name;
//	}
//    public String getEmail() {
//		return email;
//	}
//    public String getPswd() {
//		return pswd;
//	}
//    public String getCpswd() {
//		return cpswd;
//	}
//	public void setId(Long Id) {
//		this.id=Id;
//	}
//	public void setName(String name) {
//		this.name=name;
//	}
//	public void setEmail(String email) {
//		this.email=email;
//	}
//	public void setPswd(String pswd) {
//		this.pswd=pswd;
//	}
//	public void setCpswd(String cpswd) {
//		this.cpswd=cpswd;
//	}
}
