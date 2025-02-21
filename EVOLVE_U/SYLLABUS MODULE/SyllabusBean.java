package com.Syllabus;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.Courses.CourseBean;

@Entity
@Table(name = "Syllabus")
public class SyllabusBean {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "syllabus_id", nullable = false)
    private int syllabusId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseBean course;  

    @Column(name = "duration", nullable = false)
    private int duration;  

    @Column(name = "syllabus_content", nullable = false, columnDefinition = "TEXT")
    private String syllabusContent;

    @Column(name = "video_status", nullable = false)
    private boolean videoStatus;

    @Column(name = "status", nullable = false)
    private boolean status;
    
    @Column(name = "Created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    

    public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    // Default Constructor
    public SyllabusBean() {}

    // Parameterized Constructor
    public SyllabusBean(int syllabusId, CourseBean course, int duration, String syllabusContent, boolean videoStatus, boolean status) {
        this.syllabusId = syllabusId;
        this.course = course;
        this.duration = duration;
        this.syllabusContent = syllabusContent;
        this.videoStatus = videoStatus;
        this.status = status;
    }

    // Getters and Setters
    public int getSyllabusId() {
        return syllabusId;
    }
    public void setSyllabusId(int syllabusId) {
        this.syllabusId = syllabusId;
    }

    public CourseBean getCourse() {
        return course;
    }
    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getSyllabusContent() {
        return syllabusContent;
    }
    public void setSyllabusContent(String description) {
        this.syllabusContent = description;
    }

    public boolean isVideoStatus() {
        return videoStatus;
    }
    public void setVideoStatus(boolean videoStatus) {
        this.videoStatus = videoStatus;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
