package com.Mydatabase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("WELCOME TO CRUD OPERATION");
        System.out.println("----------------------------------");
        String status = "True";
        
        while (status.equalsIgnoreCase("True")) {
            System.out.println("\nMENU PAGE:");
            System.out.println("1. Create Data");
            System.out.println("2. Read Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            
            System.out.print("\nEnter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            
            if (choice == 1) {
                System.out.print("\nEnter Your Name: ");
                String name = scan.nextLine();
                
                System.out.print("Enter Your Email ID: ");
                String emailid = scan.nextLine();
                
                System.out.print("Enter Your Phone Number: ");
                String phoneno = scan.nextLine();
                
                System.out.print("Enter Your Department: ");
                String department = scan.nextLine();
                
                System.out.print("Enter Your Salary: ");
                Double salary = scan.nextDouble();
                scan.nextLine();
                
                CreateData.Create(name, emailid, phoneno, department, salary);
            } 
            
            else if (choice == 2) {
                ReadData.Read();
            } 
            
            else if (choice == 3) {
                System.out.print("\nEnter Your Name: ");
                String name = scan.nextLine();
                
                System.out.print("Enter Your Email ID: ");
                String emailid = scan.nextLine();
                
                System.out.print("Enter Your Phone Number: ");
                String phoneno = scan.nextLine();
                
                System.out.print("Enter Your Department: ");
                String department = scan.nextLine();
                
                System.out.print("Enter Your Salary: ");
                Double salary = scan.nextDouble();
                
                System.out.print("Enter Your ID: ");
                int employeeid = scan.nextInt();
                scan.nextLine();
                
                UpdateData.Update(employeeid, name, emailid, phoneno, department, salary);
            } 
            
            else {
                System.out.print("\nEnter ID to delete: ");
                int employeeid = scan.nextInt();
                scan.nextLine();
                DeleteData.Delete(employeeid);
            }
            
            System.out.print("\nWant to continue (y/n)? ");
            String option = scan.nextLine();
            System.out.println("\n------------------------------------------------------------");
            
            if (option.equalsIgnoreCase("n")) {
            	System.out.println("\nProgram Ended!!");
                break;
            }
        }
        
        scan.close();
    }
}
