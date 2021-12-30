package AAI_data_and_database.jdbc_training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class ConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		//load the driver class into memory
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//after port, set the name of the DB to which you want to connect
		final String url = "jdbc:mysql://localhost:3306/org?serverTimezone=Europe/Rome";
		final String user = "root";
		final String password = "dunpeal87$$";
		
		//connect to DB. try with resource to autoclose the connection
		try (Connection conn = DriverManager.getConnection(url,user,password)){
			System.out.println("connection established");
			String query = "SELECT * FROM Employees";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				int id = result.getInt("id");
				int age = result.getInt("age");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				System.out.println("record: "+id+", "+age+", "+first_name+", "+last_name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//or use prepared statement for e.g. INSERT
		
		/*
		try (Connection conn = DriverManager.getConnection(url,user,password)){
			System.out.println("connection established");
			
			try (PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?,?,?)")){
				ps.setString(1, email);
				ps.setString(2, password);
				ps.setString(3, fullName);
				
				int rowsAffected = ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
}
