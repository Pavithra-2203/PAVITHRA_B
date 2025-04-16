package com.hexaware.tbs.dao;

import java.util.List;
import com.hexaware.tbs.entity.*;
import com.hexaware.tbs.exception.*;

public interface IBookingSystemRepository {
    void addEvent(Event event) throws DBConnectionException;
    List<Event> getAllEvents() throws DBConnectionException;
    Event getEventById(int eventId) throws EventNotFoundException, DBConnectionException;
    void bookEvent(Booking booking) throws DBConnectionException;
    void cancelBooking(int bookingId) throws BookingNotFoundException, DBConnectionException;
    List<Booking> getAllBookings() throws DBConnectionException;
    Booking getBookingById(int bookingId) throws BookingNotFoundException, DBConnectionException;
}
