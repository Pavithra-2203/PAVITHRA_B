package com.hexaware.tbs.dao;

import java.sql.*;
import java.util.*;
import com.hexaware.tbs.entity.*;
import com.hexaware.tbs.exception.*;
import com.hexaware.tbs.util.DBUtil;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {

    @Override
    public void addEvent(Event event) throws DBConnectionException {
        String sql = "INSERT INTO event (name, type, date, venue, price, genre, director, performer, team) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, event.getName());
            ps.setString(2, event.getType());
            ps.setString(3, event.getDate());
            ps.setString(4, event.getVenue());
            ps.setDouble(5, event.getPrice());

            // Set additional fields based on the event type
            if (event instanceof Movie) {
                Movie movie = (Movie) event;
                ps.setString(6, movie.getGenre());
                ps.setString(7, movie.getDirector());
                ps.setNull(8, java.sql.Types.VARCHAR); // Performer is null for movies
                ps.setNull(9, java.sql.Types.VARCHAR); // Team is null for movies
            } else if (event instanceof Concert) {
                Concert concert = (Concert) event;
                ps.setNull(6, java.sql.Types.VARCHAR); // Genre is null for concerts
                ps.setNull(7, java.sql.Types.VARCHAR); // Director is null for concerts
                ps.setString(8, concert.getPerformer());
                ps.setNull(9, java.sql.Types.VARCHAR); // Team is null for concerts
            } else if (event instanceof Sports) {
                Sports sports = (Sports) event;
                ps.setNull(6, java.sql.Types.VARCHAR); // Genre is null for sports
                ps.setNull(7, java.sql.Types.VARCHAR); // Director is null for sports
                ps.setNull(8, java.sql.Types.VARCHAR); // Performer is null for sports
                ps.setString(9, sports.getTeam());
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBConnectionException("Error adding event: " + e.getMessage());
        }
    }

    @Override
    public List<Event> getAllEvents() throws DBConnectionException {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String type = rs.getString("type");
                Event event;

                if ("movie".equalsIgnoreCase(type)) {
                    event = new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getDouble("price"),
                        rs.getString("genre"),
                        rs.getString("director")
                    );
                } else if ("concert".equalsIgnoreCase(type)) {
                    event = new Concert(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getDouble("price"),
                        rs.getString("performer")
                    );
                } else if ("sports".equalsIgnoreCase(type)) {
                    event = new Sports(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getDouble("price"),
                        rs.getString("team")
                    );
                } else {
                    throw new DBConnectionException("Unknown event type: " + type);
                }

                events.add(event);
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Error retrieving events: " + e.getMessage());
        }
        return events;
    }

    @Override
    public Event getEventById(int eventId) throws EventNotFoundException, DBConnectionException {
        String sql = "SELECT * FROM event WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String type = rs.getString("type");

                if ("movie".equalsIgnoreCase(type)) {
                    return new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getDouble("price"),
                        rs.getString("genre"),
                        rs.getString("director")
                    );
                } else if ("concert".equalsIgnoreCase(type)) {
                    return new Concert(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getDouble("price"),
                        rs.getString("performer")
                    );
                } else if ("sports".equalsIgnoreCase(type)) {
                    return new Sports(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("venue"),
                        rs.getDouble("price"),
                        rs.getString("team")
                    );
                } else {
                    throw new EventNotFoundException("Unknown event type: " + type);
                }
            } else {
                throw new EventNotFoundException("Event with ID " + eventId + " not found.");
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Database error: " + e.getMessage());
        }
    }

    @Override
    public void bookEvent(Booking booking) throws DBConnectionException {
        String sql = "INSERT INTO booking (event_id, customer_name, email, contact) VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, booking.getEvent().getId());
            ps.setString(2, booking.getCustomer().getName());
            ps.setString(3, booking.getCustomer().getEmail());
            ps.setString(4, booking.getCustomer().getContact());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelBooking(int bookingId) throws BookingNotFoundException, DBConnectionException {
        String sql = "DELETE FROM booking WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new BookingNotFoundException("Booking with ID " + bookingId + " not found.");
            }
        } catch (SQLException e) {
            throw new BookingNotFoundException("Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Booking> getAllBookings() throws DBConnectionException {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT b.id, b.customer_name, b.email, b.contact, e.id as eid, e.name, e.type, e.date, e.venue, e.price " +
                     "FROM booking b JOIN event e ON b.event_id = e.id";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer(
                    rs.getString("customer_name"),
                    rs.getString("email"),
                    rs.getString("contact")
                );

                Event event = new Event(
                    rs.getInt("eid"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("date"),
                    rs.getString("venue"),
                    rs.getDouble("price")
                );

                Booking booking = new Booking(
                    rs.getInt("id"),
                    customer,
                    event
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Booking getBookingById(int bookingId) throws BookingNotFoundException, DBConnectionException {
        String sql = "SELECT b.id, b.customer_name, b.email, b.contact, e.id as eid, e.name, e.type, e.date, e.venue, e.price " +
                     "FROM booking b JOIN event e ON b.event_id = e.id WHERE b.id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer(
                    rs.getString("customer_name"),
                    rs.getString("email"),
                    rs.getString("contact")
                );

                Event event = new Event(
                    rs.getInt("eid"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("date"),
                    rs.getString("venue"),
                    rs.getDouble("price")
                );

                return new Booking(rs.getInt("id"), customer, event);
            } else {
                throw new BookingNotFoundException("Booking with ID " + bookingId + " not found.");
            }
        } catch (SQLException e) {
            throw new BookingNotFoundException("Database error: " + e.getMessage());
        }
    }
}