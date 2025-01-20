package com.day1;
import java.util.Scanner;

public class LoginPage {
    
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO LOG-IN PAGE");
		System.out.println("----------------------------"+"\n");
		String Name,Email,DOB;
		
		// GETTING INPUTS FROM USER
		Scanner scan = new Scanner(System.in);		
		System.out.println("Enter Your Name: ");
		Name = scan.nextLine();
		NameValidation(scan ,Name);
		Email = scan.nextLine();
		EmailValidation(scan ,Email);
		DOB = scan.nextLine();
		DOBValidation(scan ,DOB);
		Login(scan);
	}
	
	// VALIDATING NAME
	public static void NameValidation(Scanner scan , String Name) {
		if (Name.matches("[a-zA-Z]+")) {
			System.out.println("\n"+"Enter Your Email ID: ");
		}
		else {
			System.out.println("Please use only alphabets");
			System.out.println("\n"+"Re-enter Your Name: ");
			Name = scan.nextLine();
			NameValidation(scan ,Name);
		}
	}
	
	// VALIDATING EMAIL
	public static void EmailValidation(Scanner scan ,String Email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (Email.matches(emailRegex)) {
			System.out.println("\n"+"Enter Your DOB: ");
		}
		else {
			System.out.println("Please Check Your Email ID. The format should be abc@domain.com");
			System.out.println("\n"+"Re-enter Your Email ID: ");
			Email = scan.nextLine();
			EmailValidation(scan ,Email);
		}
	}
	
	// VALIDATING DOB
	public static void DOBValidation(Scanner scan ,String DOB) {
		String DOBRegex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$";
		if (DOB.matches(DOBRegex)) {
			System.out.println("\n"+"Click Login to proceed further");
		}
		else {
			System.out.println("Please Check DOB format (DD-MM-YYYY)");
			System.out.println("\n"+"Re-enter Your DOB: ");
			DOB = scan.nextLine();
			DOBValidation(scan ,DOB);
		}
	}
	
	
	// LOGIN CONFIRMATION
	public static void Login(Scanner scan) {
		System.out.println("Login?(Yes/No): ");
		String Status = scan.nextLine(); 
		if(Status.equals("Yes")) {
			System.out.println("\n"+"You are logged in successfully");
		}
		else {
			System.out.println("Sorry, log in failed");
		}
	}
}
