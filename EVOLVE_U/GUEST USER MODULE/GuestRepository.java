package com.GuestUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GuestRepository extends JpaRepository<GuestUserBean, Integer> {
    GuestUserBean findByUserId(Integer userId);
    GuestUserBean findByInstructorId(Integer instructorId);
	
}
