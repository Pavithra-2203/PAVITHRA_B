package com.hexaware.tbs.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class prepstmt {

	public static void main(String[] args) {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Register Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: Establish Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem", "root", "P@vi2203");

            // Step 3: Prepare SQL Query
            String query = "INSERT INTO event (event_id, name, type, date, time, venue, total_seats, available_seats) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Taking user input
            System.out.print("Enter Event ID: ");
            int eventId = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter Event Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Event Type (e.g., Movie/Concert/Sports): ");
            String type = sc.nextLine();

            System.out.print("Enter Event Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            System.out.print("Enter Event Time (HH:MM): ");
            String time = sc.nextLine();

            System.out.print("Enter Venue: ");
            String venue = sc.nextLine();

            System.out.print("Enter Total Seats: ");
            int totalSeats = sc.nextInt();

            System.out.print("Enter Available Seats: ");
            int availableSeats = sc.nextInt();

            // Setting values in the prepared statement
            pstmt.setInt(1, eventId);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.setString(6, venue);
            pstmt.setInt(7, totalSeats);
            pstmt.setInt(8, availableSeats);

            // Step 4: Execute
            int count = pstmt.executeUpdate();
            System.out.println(count + " record inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close connection
            try {
                if (conn != null) conn.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}