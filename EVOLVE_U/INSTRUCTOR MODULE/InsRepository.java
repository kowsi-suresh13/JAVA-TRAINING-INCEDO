package com.Instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.UserBean;

@Repository
public interface InsRepository extends JpaRepository<InstructorBean, Integer> {
    InstructorBean findByEmailId(String emailId);
    InstructorBean findByInstructorIdAndPassword(Integer instructorId, String password);
    boolean existsByInstructorId(Integer instructorId);
    InstructorBean findByInstructorId(Integer instructorId);
}
