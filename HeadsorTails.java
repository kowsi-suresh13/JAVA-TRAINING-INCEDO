package com.Assignments;

import java.util.Scanner;
import java.util.Random;

public class HeadsorTails {
	
	public String getHeadsOrTails() {
		Random random = new Random();
		int tossresult = random.nextInt(2); // creating random input 0 or 1
		
		return switch(tossresult) {
		case 0 -> "Heads";
		case 1 -> "Tails";
		default -> throw new IllegalStateException("Unexpected value error"+tossresult);
		};   
	}       
}
