package com.hexaware.tbs.task11;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookingSystemRepositoryImpl implements IBookingSystemRepository {

	 @Override
	    public Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue) {
	        try (Connection conn = DBUtil.getDBConn()) {
	            String sql = "INSERT INTO events (event_name, event_date, event_time, total_seats, ticket_price, event_type, venue_name, venue_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            stmt.setString(1, eventName);
	            stmt.setString(2, date);
	            stmt.setString(3, time);
	            stmt.setInt(4, totalSeats);
	            stmt.setDouble(5, ticketPrice);
	            stmt.setString(6, eventType);
	            stmt.setString(7, venue.getVenueName());
	            stmt.setString(8, venue.getAddress());
	            stmt.executeUpdate();

	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                System.out.println("Event created successfully with ID: " + rs.getInt(1));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public List<Event> getEventDetails() {
	        List<Event> events = new ArrayList<>();
	        try (Connection conn = DBUtil.getDBConn()) {
	            String sql = "SELECT * FROM events";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                String eventType = rs.getString("event_type");
	                Event event = null;
	                Venue venue = new Venue(rs.getString("venue_name"), rs.getString("venue_address"));

	                if (eventType.equalsIgnoreCase("Movie")) {
	                    event = new Movie(
	                        rs.getString("event_name"),
	                        rs.getString("event_date"),
	                        rs.getString("event_time"),
	                        venue,
	                        rs.getInt("total_seats"),
	                        rs.getInt("total_seats"),
	                        rs.getDouble("ticket_price"),
	                        "Genre", "Actor", "Actress"
	                    );
	                } 
	                else if (eventType.equalsIgnoreCase("Sports")) {
	                    event = new Sport(
	                        rs.getString("event_name"),
	                        rs.getString("event_date"),
	                        rs.getString("event_time"),
	                        venue,
	                        rs.getInt("total_seats"),
	                        rs.getInt("total_seats"),
	                        rs.getDouble("ticket_price"),
	                        "Sport", "Teams"
	                    );
	                } else if (eventType.equalsIgnoreCase("Concert")) {
	                    event = new Concert(
	                        rs.getString("event_name"),
	                        rs.getString("event_date"),
	                        rs.getString("event_time"),
	                        venue,
	                        rs.getInt("total_seats"),
	                        rs.getInt("total_seats"),
	                        rs.getDouble("ticket_price"),
	                        "Artist", "Type"
	                    );
	                }
	                events.add(event);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return events;
	    }

	    @Override
	    public int getAvailableNoOfTickets() {
	        int totalAvailable = 0;
	        try (Connection conn = DBUtil.getDBConn()) {
	            String sql = "SELECT SUM(total_seats) AS available_tickets FROM events";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            if (rs.next()) {
	                totalAvailable = rs.getInt("available_tickets");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return totalAvailable;
	    }

	    @Override
	    public double calculateBookingCost(int numTickets) {
	        // Placeholder for calculation logic
	        return 0;
	    }

	    @Override
	    public void bookTickets(String eventName, int numTickets, List<Customer> customers) {
	        // Placeholder for booking logic
	    }

	    @Override
	    public void cancelBooking(int bookingId) {
	        // Placeholder for cancellation logic
	    }

	    @Override
	    public Booking getBookingDetails(int bookingId) {
	        // Placeholder for fetching booking details
	        return null;
	    }
}
