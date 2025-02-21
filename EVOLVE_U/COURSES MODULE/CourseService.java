package com.Courses; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
	@Autowired 
	private CourseRepository crepo;
	
    public List<CourseBean> get() {
        return crepo.findAll();
    }
    
    public CourseBean getbyId(int id) {
        return crepo.findById(id).orElse(null); 
    }

    public CourseBean addCourse(CourseBean course) {
    	course.setCreatedAt(LocalDateTime.now());
        return crepo.save(course);
    }
   
    @Transactional  
    public CourseBean updateCourse(CourseBean updatedCourse) {
        Optional<CourseBean> optionalCourse = crepo.findById(updatedCourse.getCourseid());
        
        if (optionalCourse.isPresent()) {
            CourseBean existingCourse = optionalCourse.get();
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setCourseCode(updatedCourse.getCourseCode());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setDuration(updatedCourse.getDuration());
            existingCourse.setSyllabus(updatedCourse.getSyllabus());
            existingCourse.setPrice(updatedCourse.getPrice());
            existingCourse.setSyllabusStatus(updatedCourse.isSyllabusStatus());
            existingCourse.setStatus(updatedCourse.isStatus());
            existingCourse.setPaymentMode(updatedCourse.getPaymentMode());
            //existingCourse.setCreatedAt(LocalDateTime.now());
            return crepo.save(existingCourse);
        }
        return null;
    }
   
    public boolean deleteCourse(int id) {
        if (crepo.existsById(id)) {
            crepo.deleteById(id);
            return true;
        }
        return false;
    }

}
