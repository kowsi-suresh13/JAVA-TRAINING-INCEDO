package com.Assignments;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
	
	public static String Name() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter name to be searched: ");
		String sname = scan.nextLine();
		scan.close();
		return sname;
	}

	public static void main(String[] args) {
		HashMap<String,String> contacts  = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("YOUR PHONE BOOK"+"\n"+"--------------------"+"\n");
		String status1 = "True";
		while(status1.equalsIgnoreCase("True")) {
			System.out.println("\n"+"HOME PAGE"+"\n"+"*************");
			System.out.println("\n"+"1. Add New Contact"+"\n"+"2. Search Contact");
			System.out.print("\n"+"Enter choice : ");
			int choice = scan.nextInt();
			scan.nextLine();
			
			contacts.put("John 1", "9882628728");
			contacts.put("Louise", "9882628727");
			contacts.put("John 3", "9882628726");
			contacts.put("Harry", "9882628725");
			contacts.put("Lousy Harry", "9882628724");
			contacts.put("John Louise", "9882628723");
			
			if(choice==1) {
				String status = "True";
				while(status.equalsIgnoreCase("True")) {
				   System.out.print("\n"+"Enter Name: ");
				   String name = scan.nextLine();
				   System.out.print("Enter number : ");
				   String number = scan.nextLine();
				   addContacts(name, number,contacts);
				   System.out.print("\n"+"Want to add one more contact?(y/n): ");
				   String answer = scan.nextLine();
				   if(answer.equalsIgnoreCase("n")) {
						break;
				   }
				}
				
			}
			else {
				String sname = Name();
				SearchContacts(sname,contacts);
				break;
			}
		}
	}
	
	public static void addContacts(String name, String number, HashMap<String,String> contacts) {
		contacts.put(name, number);
		System.out.println("\n"+"New contact has been added successfully");
	}
	
	public static void SearchContacts(String search_name,HashMap<String,String> contacts) {
		System.out.println("\n"+"The contacts are:");
		for (Map.Entry<String, String> entry : contacts.entrySet()) {
           String name = entry.getKey();
           String number = entry.getValue();        
           if(name.contains(search_name)) {      	   
        	   System.out.println(number);
           }
	}
	}
}
