package com.hexaware.tbs.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.hexaware.tbs.exception.DBConnectionException;

public class DBUtil {

	 public static Connection getConnection() throws DBConnectionException {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketdb", "root", "P@vi2203");
	        } catch (Exception e) {
	            throw new DBConnectionException("Failed to connect to database: " + e.getMessage());
	        }
	    }
}
