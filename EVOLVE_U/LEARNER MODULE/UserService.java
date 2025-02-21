package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service				
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
 

   /* @Autowired
    private BCryptPasswordEncoder passwordEncoder;*/


    public String registerUser(UserBean user) {
       if (userRepository.findByEmailId(user.getemailId()) != null) {
            return "Email already registered!";
        }
        user.setpassword(user.getpassword());

        userRepository.save(user);
        return "Registration Successful!";
    }

    public String loginUser(int userId, String password) {
    	UserBean user = userRepository.findByUserIdAndPassword(userId,password);
        
        if (user != null) {
            return "Login successful";
        } else {
            return "Login Failed! Check your User ID and Password.";
        }
    }
    
    public boolean isValidUser(int userId) {
        // Check if the userId exists in the database
        return userRepository.existsByUserId(userId);
    }

    public UserBean getUserById(int userId) {
        return userRepository.findByUserId(userId);
    }
    
    @Transactional
    public String resetPassword(int userId, String newPassword) {
        // Example logic for password reset
        // Validate token, find the user, and reset the password
        UserBean user = userRepository.findByUserId(userId);
        
        if (user == null) {
            return "User not found.";
        }
        /*if (!user.getpassword().equals(oldPassword)) {
            return "Old password does not match.";
        }
        /*if (!resetToken.equals(user.getResetToken())) {
            return "Invalid token.";
        }*/

        // Proceed to update the password
        user.setpassword(newPassword); // You should hash the password before saving it
        userRepository.save(user);
        return "success";
    }
}

