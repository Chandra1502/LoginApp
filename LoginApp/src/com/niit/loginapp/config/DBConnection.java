package com.niit.loginapp.config;
import java.sql.*;

public class DBConnection {
	
	static private Connection con;

	
	public static Connection createConnection(){
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/javadb","sa",null);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
		
	
	
}	
		
	
	
	

