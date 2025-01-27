package com.Mydatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
	public static void Update(int employee_id, String name, String email_id, String phone_no, String department, Double salary) {
		String query = "Update employee SET name=?,email_id=?,phone_no=?,department=?,salary=? where employee_id=?";
		
		try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email_id);
			preparedStatement.setString(3, phone_no);
			preparedStatement.setString(4, department);
			preparedStatement.setDouble(5, salary);
			preparedStatement.setInt(6, employee_id);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected>0) {
				System.out.println("\n"+"Datas has been updated successfully");
			}
			else {
				System.out.println("\n"+"Datas has not been updated");
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}

}
