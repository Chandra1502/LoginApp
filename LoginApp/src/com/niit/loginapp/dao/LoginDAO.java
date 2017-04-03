package com.niit.loginapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.loginapp.config.DBConnection;

public class LoginDAO {
	
	ResultSet rs;
	
	// Write a simple method which takes two parameters and return true or false
	
	public boolean isValidCredentials(String id, String password){
		
		// Get the connection
		Connection con = DBConnection.createConnection();
		boolean b=true;
		// Write Query
		try {
			PreparedStatement ps = con.prepareStatement("select * from LOGIN where id=? and password=?");
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				b=true;
			else
				b=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
		
		// execute Query
		// Temporarily assuming that the username and password is niit.
		
		/*if(id.equals("niit") && password.equals("niit"))
			return true;
		else
			return false;*/
		
		
	} // The method is given as public because I need to access it from another class.

}
