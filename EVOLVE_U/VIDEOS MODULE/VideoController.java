package com.Videos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/syllabus")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    // Fetch videos for a given syllabusId
    @GetMapping("/{syllabusId}/videos")
    public String getVideosBySyllabus(@PathVariable int syllabusId, Model model) {
        List<VideoBean> videos = videoRepository.findBySyllabus_SyllabusId(syllabusId);
        model.addAttribute("videoList", videos);
        return "videos-list";  // Forward to videosList.jsp
    }

    // Display video play page
    @GetMapping("/video/play")
    public String showVideoPage(@RequestParam String videoName, Model model) {
        // Pass the videoName to the model to be used in videoPlay.jsp
        model.addAttribute("videoName", videoName);
        return "video-play"; // Return videoPlay.jsp
    }

    // Streaming video by name
    @GetMapping("/video/play/stream")
    public ResponseEntity<Resource> streamVideo(@RequestParam String videoName) {
        Optional<VideoBean> videoOptional = videoRepository.findByVideoName(videoName);

        if (videoOptional.isPresent()) {
            VideoBean video = videoOptional.get();
            // Assuming video.getVideoUrl() is the directory and video.getVideoName() is the actual file name
            String videoPath = video.getVideoUrl().replace("\\", "/") + "/" + video.getVideoName();

            try {
                Path path = Paths.get(videoPath);
                Resource resource = new UrlResource(path.toUri());

                if (resource.exists() && resource.isReadable()) {
                    return ResponseEntity.ok()
                            .contentType(MediaType.parseMediaType("video/mp4"))
                            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + video.getVideoName() + "\"")
                            .body(resource);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                // Log exception
                return ResponseEntity.internalServerError().build();
            }
        } else {
            // If video not found, return not found
            return ResponseEntity.notFound().build();
        }
    }
}
