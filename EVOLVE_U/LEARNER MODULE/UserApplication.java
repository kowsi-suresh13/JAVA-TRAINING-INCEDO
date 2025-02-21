package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.GuestUser","com.Instructor","com.Admin","com.Courses","com.Syllabus","com.Videos","com.Certificates"})
@EnableJpaRepositories(basePackages = {"com.example.demo", "com.GuestUser","com.Instructor","com.Admin","com.Courses","com.Syllabus","com.Videos","com.Certificates"}) 
@EntityScan(basePackages = {"com.example.demo", "com.GuestUser","com.Instructor","com.Admin","com.Courses","com.Syllabus","com.Videos","com.Certificates"}) 

public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
