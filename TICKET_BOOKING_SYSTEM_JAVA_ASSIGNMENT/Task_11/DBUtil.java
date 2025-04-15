package com.hexaware.tbs.task11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getDBConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ticketbookingsystem";
        String username = "root";
        String password = "P@vi2203"; // Replace with your database password
        return DriverManager.getConnection(url, username, password);
    }
}
