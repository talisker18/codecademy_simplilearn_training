package AAI_data_and_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try{  									    //step1 load the driver class  
			Class.forName("oracle.jdbc.OracleDriver");  
			  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kilogixxer87");  
			  
			Statement stmt=con.createStatement(); 			  //step3 create the statement object  
			ResultSet rs=stmt.executeQuery("select * from system.users"); //step4 execute query  
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));      
			}  
			
		}
		catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				con.close(); //step5 close the connection object
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  							
		}


	}

}
