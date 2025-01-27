package com.Mydatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
	public static void Read() {
		String query = "Select * from employee";
		
		try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery()) {    
			
			System.out.println("\n"+"EMPLOYEE DETAILS ARE:"+"\n"+"----------------------");
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

}
