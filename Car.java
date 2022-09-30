package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Car { 
	
	static Connection connection=null;
	static Statement statement =null;
	static ResultSet resultset=null;
	
	static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) throws SQLException{
		     
		    String query = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/naveen","root","");
			statement = connection.createStatement();
			
			//String query ="CREATE TABLE Naveen(Id int,Name varchar(66),Prize int)";
			//String query = "INSERT INTO Naveen VALUES (01,'car',5000000)";
			//statement.executeUpdate(query);
			
		    query = "SELECT* From naveen";
			resultset=statement.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getInt(1)+","+resultset.getString(2)+","+resultset.getInt(3));
			
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		finally {
			resultset.close();
			statement.close();
			connection.close();
			
		}
		System.out.println("done");
		
		}
}

	

    

