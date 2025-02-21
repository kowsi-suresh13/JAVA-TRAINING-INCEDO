package com.Certificates;

import com.Courses.CourseBean;
import com.example.demo.UserBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "certificates")
public class CertificateBean {

    @Id
    @Column(length = 50, nullable = false, unique = true)
    private String certificateId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password", "phoneNumber", "school", "createdAt", "updatedAt"}) // Avoid unnecessary fields
    private UserBean user;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnoreProperties({"description", "duration", "syllabus", "price", "status"}) // Avoid unnecessary fields
    private CourseBean course;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
    private LocalDate expiryDate;

    public CertificateBean() {
        this.certificateId = UUID.randomUUID().toString();
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1);
    }

    // Getters and Setters
    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
