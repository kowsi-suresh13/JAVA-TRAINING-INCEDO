package com.Mydatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateData {

	public static void Create(String name, String email_id, String phone_no, String department, Double salary) {
		String query = "Insert into employee (name, email_id, phone_no, department, salary) values(?,?,?,?,?)";
		
		try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email_id);
			preparedStatement.setString(3, phone_no);
			preparedStatement.setString(4, department);
			preparedStatement.setDouble(5, salary);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected>0) {
				System.out.println("\n"+"Datas has been added successfully");
			}
			else {
				System.out.println("\n"+"Datas has not been added");
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}

}
