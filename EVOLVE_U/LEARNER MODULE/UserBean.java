package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.Table;




@Entity
@Table(name = "Learners")

public class UserBean {
	
	
	
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "UserId")
	private int userId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "School")
	private String school;
	
	@Column(name = "Created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

	@Column(name = "reset_token", nullable = true, updatable = false)
	private String resetToken;
	
	//public UserBean() {}
	
	
	
	
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public int getuserId() {
		return userId;
	}
	
	public void setuserId(int userId) {
		this.userId = userId;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	
	public String getemailId() {
		return emailId;
	}
	
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getphoneNumber() {
		return phoneNumber;
	}
	
	public void setschool(String school) {
		this.school = school;
	}
	
	public String getschool() {
		return school;
	}
	
	public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

	public String getResetToken() {
		return resetToken;
	}
	
    
}
