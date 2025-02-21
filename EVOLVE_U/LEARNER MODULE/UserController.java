package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import java.time.LocalDateTime;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import com.GuestUser.*;
import com.GuestUser.GuestUserBean.RoleName;
import com.Instructor.*;
import com.mysql.cj.Session;
import com.GuestUser.GuestUserService;

@Controller

public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private GuestUserService guestUserService;
	

	UserBean user = new UserBean();
	
	GuestUserBean guest = new GuestUserBean();
	
	
    InstructorBean instructor = new InstructorBean();
	/*@GetMapping("/page")
    public String homePage() {
        return "welcome";  // This maps to /WEB-INF/jsp/welcome.jsp
    } 
	/*@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", defaultValue = "Guest") String name,Model model) {
        // Pass the 'name' parameter to the JSP view
		model.addAttribute("name", name);
        return "greet"; // This will map to greet.jsp
	}*/
	/*@RequestMapping("/error")
	public String handleError() {
		return "error";  //This will map to error.jsp
	}*/
    
    @GetMapping("/frontpage")
    public String showFront() {
    	return "frontpage";
    }
    
    
	
	@GetMapping("/login/learner")
	public String showForm(HttpSession session) {
		
		return "login";
	}
	
	@GetMapping("/registerLearner")
    public String showRegistrationForm() {
        return "register";  // Registration page
    }
	
	@GetMapping("/resetPassword")
	public String showResetPasswordPage(Model model) { 
		//System.out.println("Received resetToken: " + resetToken); 
		//model.addAttribute("resetToken", resetToken);        
		return "reset-password"; 
	}
	
	@PostMapping("/submit-reset")
    public String processResetPassword(
        @RequestParam("userId") int userId, // Added userId field
       // @RequestParam("resetToken") String resetToken, 
        @RequestParam("oldPassword") String oldPassword, 
        @RequestParam("newPassword") String newPassword, 
        Model model) {
        System.out.println(userId);
        // Validate userId (you could also use a service to check if the user exists in the database)
        if (userService.isValidUser(userId)) {
            // Validate token and reset password
        	System.out.println("I am here");
            String response = userService.resetPassword(userId, newPassword);

            if (response.equals("success")) {
                model.addAttribute("message", "Password successfully reset. Please log in.");
                return "redirect:/login/learner"; // Redirect to login page after successful reset
            } else {
                model.addAttribute("message", response); // Display error message if reset fails
                return "reset-password"; // Show reset password page again
            }
        } else {
            // If userId is invalid, show an error message
            model.addAttribute("message", "Invalid user ID.");
            return "reset-password"; // Stay on the reset password page
        }
    }
	
	
	@GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        // Retrieve the userId from the session
		Integer sessionUserId = (Integer) session.getAttribute("userId");
        System.out.println("Session userId: " + sessionUserId); 
        if (sessionUserId != null) {
            // Fetch the user's profile using the userId
            UserBean user = userService.getUserById(sessionUserId);
            if (user != null) {
                // Pass the user details to the view
                model.addAttribute("user", user);
                return "user-profile";  // Show the profile page
            } else {
                model.addAttribute("message", "User not found.");
                return "error";  // Handle error if user not found
            }
        } else {
            model.addAttribute("message", "User not logged in.");
            return "redirect:/login/learner";  // Redirect to login if no userId found
        }
    }
    
	
	@GetMapping("/roleSelection")
    public String showRoleSelectionPage() {
        return "role";  // This maps to the roleSelection.jsp page
    }
	
	@PostMapping("/selectRole")
    public String handleRoleSelection(@RequestParam("role") RoleName role) {
        if (role==RoleName.Learner) {
        	guest.setRole(role);
            return "redirect:/registerLearner"; // Redirect to Learner registration page
        } else if (role==RoleName.Instructor) {
        	guest.setRole(role);
            return "redirect:/registerInstructor"; // Redirect to Instructor registration page
        }
        return "redirect:/login/learner"; // Default redirect in case of invalid role
    }
	
	@PostMapping("/submitForm")
    public String login(@RequestParam("userId") int userId,
                        @RequestParam("password") String password,
                        Model model,HttpSession session) {

        // Call service to check if the login is successful
        String result = userService.loginUser(userId, password);

        if (result.startsWith("Login successful")) {
            // If login is successful, redirect to the success page
            model.addAttribute("message", result);
            session.setAttribute("userId", userId);
            return "user-page"; // Redirects to success.jsp
        } else {
            // If login fails, display error on the login page
            model.addAttribute("error", result); // Pass the error message to the JSP
            return "login"; // Show login page again with error message
        }
    }
	
	@PostMapping("/submitRegistration")
    public String register(@RequestParam("userId") int userId,
                           @RequestParam("name") String name,
                           @RequestParam("emailId") String emailId,
                           @RequestParam("password") String password,
                           @RequestParam("phoneNumber") String phoneNumber,
                           @RequestParam("school") String school,
                           Model model,RedirectAttributes redirectAttributes) {
		
        // Create a new user bean and set the values
      
        user.setuserId(userId);
        user.setname(name);
        user.setemailId(emailId);
        user.setpassword(password);
        user.setphoneNumber(phoneNumber);
        user.setschool(school);
        user.setCreatedAt(LocalDateTime.now());

        // Call service to register the user
        String result1 = userService.registerUser(user);
        guest.setUserId(user.getuserId());
        guest.setCreatedAt(LocalDateTime.now());
        String result2 = guestUserService.registerUser(guest);

        if (result1.equals("Registration Successful!") || result2.equals("Registration Successful!")) {
        	redirectAttributes.addFlashAttribute("registrationSuccess", "Registration Successful!");
            model.addAttribute("message", result1);
            return "/login/learner";  // Redirect to login page after successful registration
        } else {
        	redirectAttributes.addFlashAttribute("registrationError", result1);
            model.addAttribute("error", result1);  // Show error message on registration page
            return "register";  // Stay on registration page with error message
        }
    }

}
 