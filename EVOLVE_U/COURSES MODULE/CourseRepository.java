package com.Courses; 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends JpaRepository<CourseBean, Integer> {
	Optional<CourseBean> findByName(String name); 
}
