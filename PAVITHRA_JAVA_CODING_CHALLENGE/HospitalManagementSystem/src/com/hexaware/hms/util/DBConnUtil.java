package com.hexaware.hms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/hospitalmanagementsystem";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "P@vi2203";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
