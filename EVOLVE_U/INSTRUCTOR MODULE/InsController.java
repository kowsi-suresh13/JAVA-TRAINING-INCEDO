package com.Instructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GuestUser.GuestUserBean;
import com.GuestUser.GuestUserService;


@Controller
public class InsController {
	
	@Autowired
    private InstructorService instructorService;
	
	@Autowired
	private GuestUserService guestUserService;
	
	GuestUserBean guest = new GuestUserBean();
	
	@GetMapping("/login/instructor")
	public String showForm() {
		return "instlogin";
	}
	
	@GetMapping("/registerInstructor")
    public String showInstructorRegistrationForm() {
        return "instregister";  // Instructor registration page
    }
	
	@GetMapping("/resetIns")
	public String showResetPasswordPage(Model model) { 
		//System.out.println("Received resetToken: " + resetToken); 
		//model.addAttribute("resetToken", resetToken);        
		return "instructor-reset"; 
	}
	
	@PostMapping("/ins-reset")
    public String processResetPassword(
        @RequestParam("instructorId") int instructorId, // Added userId field
       // @RequestParam("resetToken") String resetToken, 
        @RequestParam("oldPassword") String oldPassword, 
        @RequestParam("newPassword") String newPassword, 
        Model model) {
        System.out.println(instructorId);
        // Validate userId (you could also use a service to check if the user exists in the database)
        if (instructorService.isValidUser(instructorId)) {
            // Validate token and reset password
        	System.out.println("I am here");
            String response = instructorService.resetPassword(instructorId, newPassword);

            if (response.equals("success")) {
                model.addAttribute("message", "Password successfully reset. Please log in.");
                return "redirect:/login/instructor"; // Redirect to login page after successful reset
            } else {
                model.addAttribute("message", response); // Display error message if reset fails
                return "instructor-reset"; // Show reset password page again
            }
        } else {
            // If userId is invalid, show an error message
            model.addAttribute("message", "Invalid user ID.");
            return "instructor-reset"; // Stay on the reset password page
        }
    }
	
	@PostMapping("/submitinsRegistration")
    public String instregister(@RequestParam("instructorId") int instructorId,
                           @RequestParam("name") String name,
                           @RequestParam("emailId") String emailId,
                           @RequestParam("password") String password,
                           @RequestParam("phoneNumber") String phoneNumber,
                           @RequestParam("qualification") String qualification,
                           @RequestParam("workExperience") int workExperience,
                           @RequestParam("achievement") String achievement,
                           Model model,RedirectAttributes redirectAttributes) {
	
        // Create a new user bean and set the values
        InstructorBean instructor = new InstructorBean();
        instructor.setInstructorId(instructorId);
        instructor.setName(name);
        instructor.setEmailId(emailId);
        instructor.setPassword(password);
        instructor.setPhoneNumber(phoneNumber);
        instructor.setQualification(qualification);
        instructor.setAchievement(achievement);
        instructor.setWorkExperience(workExperience);
        instructor.setCreatedAt(LocalDateTime.now());

        // Call service to register the user
        String result = instructorService.registerIns(instructor);
        guest.setInstructorId(instructor.getInstructorId());
        guest.setCreatedAt(LocalDateTime.now());
        String result2 = guestUserService.registerInst(guest);

        if (result.equals("Registration Successful!")) {
        	redirectAttributes.addFlashAttribute("registrationSuccess", "Registration Successful!");
            model.addAttribute("message", result);
            return "redirect:/login/instructor";  // Redirect to login page after successful registration
        } else {
        	redirectAttributes.addFlashAttribute("registrationError", result);
            model.addAttribute("error", result);  // Show error message on registration page
            return "register";  // Stay on registration page with error message
        }
    }

	@PostMapping("/submit")
    public String login(@RequestParam("instructorId") int instructorId,
                        @RequestParam("password") String password,
                        Model model,HttpSession session) {

        // Call service to check if the login is successful
        String result = instructorService.loginIns(instructorId, password);

        if (result.startsWith("Login successful")) {
            // If login is successful, redirect to the success page
        	session.setAttribute("instructorId",instructorId );
            model.addAttribute("message", result);
            return "course-home"; // Redirects to success.jsp
        } else {
            // If login fails, display error on the login page
            model.addAttribute("error", result); // Pass the error message to the JSP
            return "instlogin"; // Show login page again with error message
        }
    }


}
