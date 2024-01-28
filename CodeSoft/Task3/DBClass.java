import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass {

	private static Connection con = null;

//	Creating connection to the database
	static Connection getConnect() {
			try {
				
				// Load driver class
				Class.forName("com.mysql.cj.jdbc.Driver");

				//Create connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codesoft", "root", "1234");
			} catch (Exception e) {
				System.out.println("Error :"+e);
			}
		return con;
	}

}
