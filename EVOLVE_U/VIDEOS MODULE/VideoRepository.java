package com.Videos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<VideoBean, Integer> {
	Optional<VideoBean> findByVideoName(String videoName);

	List<VideoBean> findBySyllabus_SyllabusId(int syllabusId);
}
