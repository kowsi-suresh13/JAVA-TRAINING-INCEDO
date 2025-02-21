package com.Courses;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;

@Controller

public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String getHomepage() {
        return "course-home";
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<CourseBean> courses = courseService.get();
        model.addAttribute("courses", courses);
        return "course-list";
    }
    
    @GetMapping("/courses/{id}")
    public String showCourseDetails(@PathVariable int id, Model model) {
        CourseBean course = courseService.getbyId(id);
        if (course == null) {
            return "redirect:/courses"; 
        }
        model.addAttribute("course", course);
        return "course-details"; 
    }

    @GetMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new CourseBean());
        return "add-course";
    }

    @PostMapping("/courses/add")
    public String addCourse(@ModelAttribute CourseBean course, Model model) {
        CourseBean newCourse = courseService.addCourse(course);
        if (newCourse != null) {
            model.addAttribute("message", "Course Added Successfully");
        } else {
            model.addAttribute("message", "Failed to Add Course");
        }
        model.addAttribute("course", new CourseBean());
        return "add-course";
    }

    @GetMapping("/courses/update")
    public String showUpdateCourseIdPage() {
        return "update-courseid";
    }

    @GetMapping("/courses/update/{id}")
    public String redirectToUpdatePage(@PathVariable("id") int courseId, Model model) {
        
        
        CourseBean course = courseService.getbyId(courseId);
        
        if (course != null) {
            model.addAttribute("course", course);
            return "update-course";
        } else {
            model.addAttribute("message", "Course Not Found");
            return "update-courseid";
        }
    }

    @PostMapping("/courses/update/{id}")
    public String updateCourse(@PathVariable("id") int id, @ModelAttribute CourseBean updatedCourse, Model model) {
        System.out.println("Received Course ID for Update: " + id);
        
        updatedCourse.setCourseid(id); 

        CourseBean updated = courseService.updateCourse(updatedCourse);

        if (updated != null) {
            model.addAttribute("message", "Course Updated Successfully");
        } else {
            model.addAttribute("message", "Update Failed. Course Not Found.");
        }

        model.addAttribute("course", updatedCourse);
        return "update-course";
    }
    
    @GetMapping("/courses/delete")
    public String showDeleteCoursePage(Model model) {
        List<CourseBean> courses = courseService.get();
        model.addAttribute("courses", courses);
        return "delete-course";
    }

    @PostMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id, Model model) {
        boolean isDeleted = courseService.deleteCourse(id);
        
        if (isDeleted) {
            model.addAttribute("message", "Course Successfully Deleted!");
        } else {
            model.addAttribute("message", "Failed to Delete Course: Course Not Found!");
        }

        
        List<CourseBean> courses = courseService.get();
        model.addAttribute("courses", courses);

        return "delete-course"; 
    }


}
