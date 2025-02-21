package com.Instructor;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserBean;



@Service				
public class InstructorService {

    @Autowired
    private InsRepository instructorRepository;
    
 
    public String registerIns(InstructorBean instructor) {
       if (instructorRepository.findByEmailId(instructor.getEmailId()) != null) {
            return "Email already registered!";
        }
        instructor.setPassword(instructor.getPassword());

        instructorRepository.save(instructor);
        return "Registration Successful!";
    }

    public String loginIns(int instructorId, String password) {
    	InstructorBean instructor = instructorRepository.findByInstructorIdAndPassword(instructorId,password);
        
        if (instructor != null) {
            return "Login successful";
        } else {
            return "Login Failed! Check your User ID and Password.";
        }
    }
    
    public boolean isValidUser(int instructorId) {
        // Check if the userId exists in the database
        return instructorRepository.existsByInstructorId(instructorId);
    }

    public InstructorBean getUserById(int instructorId) {
        return instructorRepository.findByInstructorId(instructorId);
    }
    
    @Transactional
    public String resetPassword(int instructorId, String newPassword) {
        // Example logic for password reset
        // Validate token, find the user, and reset the password
        InstructorBean instructor = instructorRepository.findByInstructorId(instructorId);
        
        if (instructor == null) {
            return "Instructor not found.";
        }
        /*if (!user.getpassword().equals(oldPassword)) {
            return "Old password does not match.";
        }
        /*if (!resetToken.equals(user.getResetToken())) {
            return "Invalid token.";
        }*/

        // Proceed to update the password
        instructor.setPassword(newPassword); // You should hash the password before saving it
        instructorRepository.save(instructor);
        return "success";
    }
}


