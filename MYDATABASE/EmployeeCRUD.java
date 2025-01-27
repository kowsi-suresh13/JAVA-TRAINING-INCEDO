package com.Mydatabase;

import java.util.Scanner;
import java.sql.*;
import java.sql.ResultSet;

public class EmployeeCRUD {

	private static final String url = "jdbc:mysql://localhost:3306/Mydatabase";
	private static final String user = "root";
	private static final String password = "Incedo@1234";
	
	
	public static void Create(String name, String email_id, String phone_no, String department, Double salary) {
		String query = "Insert into employee (name, email_id, phone_no, department, salary) values(?,?,?,?,?)";
		
		try (Connection connection = DriverManager.getConnection(url,user,password);PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email_id);
			preparedStatement.setString(3, phone_no);
			preparedStatement.setString(4, department);
			preparedStatement.setDouble(5, salary);
			
			int rowsAffected = preparedStatement.executeUpdate();
			//scan.nextLine();
			
			if(rowsAffected>0) {
				System.out.println("\n"+"Datas added successfully");
			}
			else {
				System.out.println("\n"+"Datas did not added");
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}
	
	
	public static void Read() {
		String query = "Select * from employee";
		
		try (Connection connection = DriverManager.getConnection(url,user,password);PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery()) {    
			
			while(resultSet.next()) {
				int employee_id = resultSet.getInt("employee_id");
				String name1 = resultSet.getString("name");
				String email_id1 = resultSet.getString("email_id");
				String phone_no1 = resultSet.getString("phone_no");
				String department1 = resultSet.getString("department");
				Double salary1 = resultSet.getDouble("salary");
				
				System.out.println("\n"+"EMPLOYEE ID : "+ employee_id+ "\t"+"NAME : "+name1+"\t"+"EMAIL ID : "+email_id1+"\t"+"PHONE NUMBER : "+phone_no1+"\t"+"DEPARTMENT : "+department1+"\t"+"SALARY : "+salary1);
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}
	
	public static void Update(int employee_id, String name, String email_id, String phone_no, String department, Double salary) {
		String query = "Update employee SET name=?,email_id=?,phone_no=?,department=?,salary=? where employee_id=?";
		
		try (Connection connection = DriverManager.getConnection(url,user,password);PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email_id);
			preparedStatement.setString(3, phone_no);
			preparedStatement.setString(4, department);
			preparedStatement.setDouble(5, salary);
			preparedStatement.setInt(6, employee_id);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected>0) {
				System.out.println("\n"+"Datas added successfully");
			}
			else {
				System.out.println("\n"+"Datas did not added");
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}
	
	public static void Delete(int employee_id) {
		String query = "Delete from employee where employee_id=?";
		
		try (Connection connection = DriverManager.getConnection(url,user,password);PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			preparedStatement.setInt(1, employee_id);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected>0) {
				System.out.println("\n"+"Datas deleted successfully");
			}
			else {
				System.out.println("\n"+"Datas did not deleted");
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}
	
	
	public static void main(String[] args) {
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("WELCOME TO CRUD OPEARTION"+"\n"+"----------------------------------"+"\n");
		String Status = "True";
		while(Status.equalsIgnoreCase("True")) {
			System.out.print("\n"+"MENU PAGE:"+"\n");
			System.out.print("\n"+"1. Create Datas"+"\n"+"2. Read Datas"+"\n"+"3. Update Dadats"+"\n"+"4. Delete Datas"+"\n");
			
			System.out.print("\n"+"Enter your choice : ");
			int choice = scan.nextInt();
			scan.nextLine();
			
			if(choice==1) {
				System.out.print("\n"+"Enter Your Name: ");
				String name = scan.nextLine();
				
				System.out.print("Enter Your Email ID: ");
				String emailid = scan.nextLine();
				
				System.out.print("Enter Your Phone Number: ");
				String phoneno = scan.nextLine();
				 	
				System.out.print("Enter Your department: ");
				String department = scan.nextLine();
				
				System.out.print("Enter Your salary: ");
				Double salary = scan.nextDouble();
				scan.nextLine();
				
				Create(name,emailid,phoneno,department,salary);
			}
			
			else if(choice==2) {
				Read();
			}
			else if(choice==3) {
				System.out.print("\n"+"Enter Your Name: ");
				String name = scan.nextLine();
				
				System.out.print("Enter Your Email ID: ");
				String emailid = scan.nextLine();
				
				System.out.print("Enter Your Phone Number: ");
				String phoneno = scan.nextLine();
				 	
				System.out.print("Enter Your department: ");
				String department = scan.nextLine();
				
				System.out.print("Enter Your salary: ");
				Double salary = scan.nextDouble();
				
				System.out.print("Enter Your id: ");
				int employeeid = scan.nextInt();
				scan.nextLine();
				
				Update(employeeid, name,emailid,phoneno,department,salary);
			}
			else {
				System.out.print("\n"+"Enter ID : ");
				int employeeid = scan.nextInt();
				scan.nextLine();
				Delete(employeeid);
			}
			
			System.out.print("\n"+"Want to continue(y/n) : ");
			String option = scan.nextLine();
			System.out.print("\n"+"------------------------------------------------------------");
			
			if(option.equalsIgnoreCase("n")) {
				break;
			}
		}

	}

}
