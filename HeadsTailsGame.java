package com.Assignments;

import java.util.Scanner;
import java.util.Random;
import com.Assignments.HeadsorTails;

public class HeadsTailsGame {

	public static void main(String[] args) {
		
		System.out.print("WELCOME TO HEADS OR TAILS GAME"+"\n"+"--------------------------------");
		Scanner scan  = new Scanner(System.in);
		HeadsorTails coin = new HeadsorTails();
		int score = 0;
		String status = "True";
		
		
		while(status.equalsIgnoreCase("True")) {
			System.out.print("\n"+"Guess Heads or Tails: ");
			String userin = scan.nextLine(); 
			
			// validating user input 
			if(!((userin.equalsIgnoreCase("Heads"))||(userin.equalsIgnoreCase("Tails")))){
				System.out.print("Invalid Input. Kindly enter Heads or Tails");
			}
			
			// printing toss result
			String tossresult = coin.getHeadsOrTails();
			System.out.print("TossResult is: "+tossresult);
			
			if(userin.equalsIgnoreCase(tossresult)) {
				System.out.print("\n"+"Congratulations. You Won"+"\n");
				score +=1;
			}
			else {
				System.out.print("\n"+"Sorry. You Failed"+"\n");
			}
			
			// To replay
			System.out.print("\n"+"Replay?(y/n):");
			String confirm = scan.nextLine();
			if(!(confirm.equalsIgnoreCase("y"))) {
		           System.out.print("\n"+"Your score is: "+score);
			       break;
		    }
			
		}	
	}

}

