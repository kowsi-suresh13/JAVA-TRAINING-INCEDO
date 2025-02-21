package com.Certificates;


import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Courses.CourseBean;
import com.Courses.CourseBean.CourseStatus;
import com.Courses.CourseRepository;
import com.example.demo.UserBean;
import com.example.demo.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class CertificateController {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CertificateRepository certificateRepository;
    private final CertificateGeneratorService certificateGeneratorService;

    public CertificateController(UserRepository userRepository, CourseRepository courseRepository,
                                 CertificateRepository certificateRepository,
                                 CertificateGeneratorService certificateGeneratorService) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.certificateRepository = certificateRepository;
        this.certificateGeneratorService = certificateGeneratorService;
    }

    // ✅ Show Certificate Form
    @GetMapping("/certificatesform")
    public String showCertificateForm() {
        return "certificate-form"; // Returns certificate-form.jsp
    }

    // ✅ Handle GET Request for /generateCertificate to Prevent 405 Error
    @GetMapping("/generateCertificates")
    public String redirectToCertificateForm() {
        return "redirect:/certificatesform"; // Redirects to the form
    }

    // ✅ Show Certificate Success Page
    @GetMapping("/certificatesuccess")
    public String showCertificateSuccessPage() {
        return "certificate-success"; // Returns certificate-success.jsp
    }

    // ✅ Handle Certificate Generation
    @PostMapping("/generateCertificate")
    public String generateCertificate(@RequestParam("userId") int userId,
                                      @RequestParam("Name") String name,
                                      Model model, HttpServletResponse response) {
        Optional<UserBean> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            model.addAttribute("error", "User not found.");
            return "certificate-error"; // Redirect to certificate-error.jsp
        }
        UserBean user = userOptional.get();

        // Improved Course Lookup
        CourseBean course = courseRepository.findByName(name).orElse(null);
        if (course == null) {
            model.addAttribute("error", "Course not found.");
            return "certificate-error"; // Redirect to certificate-error.jsp
        }

        if (course.isStatus()!= course.isActive()) {
            model.addAttribute("error", "Your task is not completed. Please go and complete it.");
            return "certificate-error"; // Redirect to certificate-error.jsp
        }

        // ✅ Create and Save Certificate
        CertificateBean certificate = new CertificateBean();
        certificate.setUser(user);
        certificate.setCourse(course);
        certificate.setIssueDate(LocalDate.now());
        certificate.setExpiryDate(LocalDate.now().plusYears(1));
        certificateRepository.save(certificate);

        // ✅ Add Attributes for JSP Success Page
        model.addAttribute("user", user);
        model.addAttribute("course", course);
        model.addAttribute("certificateId", certificate.getCertificateId());

        return "certificate-success"; // Redirect to certificate-success.jsp
    }
}
