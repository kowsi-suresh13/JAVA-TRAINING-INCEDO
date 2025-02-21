package com.GuestUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GuestUserService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	
	
	public String registerUser(GuestUserBean guest) {
	       if (guestRepository.findByUserId(guest.getUserId())!= null) {
	            return "You have already registered";
	        }

	        guestRepository.save(guest);
	        return "Registration Successful!";
	    }
	
	public String registerInst(GuestUserBean guest) {
	       if (guestRepository.findByInstructorId(guest.getInstructorId())!= null) {
	            return "You have already registered";
	        }

	        guestRepository.save(guest);
	        return "Registration Successful!";
	    }
	
	
}
