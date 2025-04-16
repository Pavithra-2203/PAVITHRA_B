package com.hexaware.tbs.service;

import java.util.List;
import com.hexaware.tbs.entity.*;
import com.hexaware.tbs.exception.*;

public interface IBookingService {
    void createEvent(Event event) throws DBConnectionException;
    List<Event> listAllEvents() throws DBConnectionException;
    Event getEventDetails(int eventId) throws EventNotFoundException, DBConnectionException;
    void bookTicket(int eventId, Customer customer) throws EventNotFoundException, DBConnectionException;
    void cancelBooking(int bookingId) throws BookingNotFoundException, DBConnectionException;
    List<Booking> getAllBookings() throws DBConnectionException;
    Booking getBookingById(int bookingId) throws BookingNotFoundException, DBConnectionException;
}
