package com.Instructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.Table;

@Entity
@Table(name = "Instructor")

public class InstructorBean {
	
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "InstructorId")
	private int instructorId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "Qualification")
	private String qualification;
	
	@Column(name = "WorkExperience")
	private int workExperience;
	
	@Column(name = "Achievement")
	private String achievement;
	
	
	@Column(name = "Created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

	public int getInstructorId() {
		return instructorId;
	}


	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public int getWorkExperience() {
		return workExperience;
	}


	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}


	public String getAchievement() {
		return achievement;
	}


	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	
}
