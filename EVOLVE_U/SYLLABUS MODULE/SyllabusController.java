package com.Syllabus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Courses.CourseBean;
import com.Courses.CourseService;



@Controller
//@RequestMapping("/home/courses")
public class SyllabusController {

    @Autowired
    private SyllabusService syllabusService;

    @Autowired
    private CourseService courseService; 

    
    @GetMapping("/{id}/syllabus")
    public String showSyllabus(@PathVariable int id, Model model) {
        CourseBean course = courseService.getbyId(id); 
        List<SyllabusBean> syllabusList = syllabusService.getSyllabusByCourseId(id);

        model.addAttribute("course", course);  
        model.addAttribute("syllabusList", syllabusList.isEmpty() ? null : syllabusList);  

        return "syllabus";  
    }
    
 
    @GetMapping("/syllabus/ask")
    public String showCourseIdForm() {
        return "ask-courseid";  
    }

    
    @PostMapping("/syllabus/ask")
    public String processCourseId(@RequestParam int courseId) {
        return "redirect:/" + courseId + "/syllabus/add";  
    }

    
   
    @GetMapping("/{courseId}/syllabus/add")
    public String showAddSyllabusPage(@PathVariable int courseId, Model model) {
        SyllabusBean syllabus = new SyllabusBean();
        CourseBean course = new CourseBean();
        course.setCourseid(courseId);
        syllabus.setCourse(course);  
        model.addAttribute("syllabus", syllabus);
        return "add-syllabus";
    }
    
    
    @PostMapping("/{courseId}/syllabus/add")
    public String addSyllabus(@PathVariable int courseId,
                              @RequestParam String description,
                              @RequestParam int duration,
                              @RequestParam boolean videoStatus,
                              @RequestParam boolean status,
                              Model model) {
        syllabusService.addSyllabus(courseId, description, duration, videoStatus, status);
        model.addAttribute("message", "Success! Syllabus Added.");
        model.addAttribute("syllabus", new SyllabusBean());  

        return "add-syllabus";
    }
    
    @GetMapping("/syllabus/update")
    public String showSelectCoursePage() {
        return "update-sylselectcourse";
    }

    
    @GetMapping("/syllabus/update/list")
    public String showSyllabusList(@RequestParam("courseId") int courseId, Model model) {
        CourseBean course = courseService.getbyId(courseId);
        List<SyllabusBean> syllabusList = syllabusService.getSyllabusByCourseId(courseId);

        model.addAttribute("course", course);
        model.addAttribute("syllabusList", syllabusList);
        return "update-syllabuslist";
    }

    
    @GetMapping("/syllabus/update/{id}")
    public String showUpdateSyllabusPage(@PathVariable int id, Model model) {
        SyllabusBean syllabus = syllabusService.getById(id);
        model.addAttribute("syllabus", syllabus);
        return "update-syllabus";
    }

   
    @PostMapping("/syllabus/update")
    public String updateSyllabus(@RequestParam int syllabusId,
                                 @RequestParam String description,
                                 @RequestParam int duration,
                                 @RequestParam boolean videoStatus,
                                 @RequestParam boolean status,
                                 Model model) {
        syllabusService.updateSyllabus(syllabusId, description, duration, videoStatus, status);
        model.addAttribute("message", "Syllabus updated successfully!");
        return "update-syllabus";
    }
    
    @GetMapping("/syllabus/delete")
    public String showDeleteCoursePage(Model model) {
        List<SyllabusBean> courses = syllabusService.get();
        model.addAttribute("courses", courses);
        return "delete-syllabus";
    }

    @PostMapping("/syllabus/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id, Model model) {
        boolean isDeleted = syllabusService.deleteCourse(id);
        
        if (isDeleted) {
            model.addAttribute("message", "Course Successfully Deleted!");
        } else {
            model.addAttribute("message", "Failed to Delete Course: Course Not Found!");
        }

        
        List<SyllabusBean> courses = syllabusService.get();
        model.addAttribute("courses", courses);

        return "delete-syllabus"; 
    }

}
