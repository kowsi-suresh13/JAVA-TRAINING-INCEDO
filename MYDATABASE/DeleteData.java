package com.Mydatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
	
	public static void Delete(int employee_id) {
		String query = "Delete from employee where employee_id=?";
		
		try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			preparedStatement.setInt(1, employee_id);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected>0) {
				System.out.println("\n"+"Datas has been deleted successfully");
			}
			else {
				System.out.println("\n"+"Datas has not been deleted");
			}
		}
		catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
				
	}

}
