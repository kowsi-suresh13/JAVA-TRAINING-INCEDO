package com.Videos;

import javax.persistence.*;

import com.Syllabus.SyllabusBean;

@Entity
@Table(name = "videos")
public class VideoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "video_id")
    private int videoId;

    @ManyToOne
    @JoinColumn(name = "syllabus_id", nullable = false) // Foreign key to syllabus table
    private SyllabusBean syllabus;
    
    @Column(name = "video_name", nullable = false)
    private String videoName;

    @Column(name = "video_title", nullable = false, length = 255)
    private String videoTitle;

    @Column(name = "video_url", nullable = false, length = 500)
    private String videoUrl;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "status", nullable = false)
    private boolean status;

    
    // Default Constructor
    public VideoBean() {
    }

    // Parameterized Constructor
    public VideoBean(int videoId, String videoName, SyllabusBean syllabus, String videoTitle, String videoUrl, int duration, boolean status) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.syllabus = syllabus;
        this.videoTitle = videoTitle;
        this.videoUrl = videoUrl;
        this.duration = duration;
        this.status = status;
    }

    // Getters & Setters
    public int getVideoId() {
        return videoId;
    }

    public String getVideoName() {  // Ensure this getter exists
        return videoName;
    }
    
    public void setVideoName(String name)
    {
    	this.videoName = name;
    }

    public SyllabusBean getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(SyllabusBean syllabus) {
        this.syllabus = syllabus;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
