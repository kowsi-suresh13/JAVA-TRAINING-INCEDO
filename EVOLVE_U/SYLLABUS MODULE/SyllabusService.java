package com.Syllabus;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Courses.CourseBean;
import com.Courses.CourseRepository;


@Service
public class SyllabusService {
	
	@Autowired
	SyllabusRepository srepo;
	
	 @Autowired
	 private CourseRepository crepo;
	
	public List<SyllabusBean> get()
	{
		return srepo.findAll();
	}

	public List<SyllabusBean> getSyllabusByCourseId(int courseId) {
        return srepo.findByCourseId(courseId); 
    }
	
	public void addSyllabus(int courseId, String description, int duration, boolean videoStatus, boolean status) {
        CourseBean course = crepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        SyllabusBean syllabus = new SyllabusBean();
        syllabus.setCourse(course);
        syllabus.setSyllabusContent(description);
        syllabus.setDuration(duration);
        syllabus.setVideoStatus(videoStatus);
        syllabus.setStatus(status);
        syllabus.setCreatedAt(LocalDateTime.now());
        srepo.save(syllabus);
    }
	
	public void updateSyllabus(int syllabusId, String description, int duration, boolean videoStatus, boolean status) {
        SyllabusBean syllabus = srepo.findById(syllabusId).orElse(null);
        if (syllabus != null) {
            syllabus.setSyllabusContent(description);
            syllabus.setDuration(duration);
            syllabus.setVideoStatus(videoStatus);
            syllabus.setStatus(status);
            srepo.save(syllabus);
        }
    }

	public SyllabusBean getById(int id) {
        return srepo.findById(id).orElse(null);
    }
	
	public boolean deleteCourse(int id)
	{
		if (srepo.existsById(id)) {
            srepo.deleteById(id);
            return true;
        }
        return false;
	}

}
