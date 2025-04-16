package com.hexaware.tbs.service;

import java.util.List;

import com.hexaware.tbs.dao.BookingSystemRepositoryImpl;
import com.hexaware.tbs.dao.IBookingSystemRepository;
import com.hexaware.tbs.entity.Booking;
import com.hexaware.tbs.entity.Customer;
import com.hexaware.tbs.entity.Event;
import com.hexaware.tbs.exception.BookingNotFoundException;
import com.hexaware.tbs.exception.EventNotFoundException;
import com.hexaware.tbs.exception.DBConnectionException;

public class BookingServiceImpl implements IBookingService {

    private IBookingSystemRepository repository = new BookingSystemRepositoryImpl();

    @Override
    public void createEvent(Event event) throws DBConnectionException {
        repository.addEvent(event);
    }

    @Override
    public List<Event> listAllEvents() throws DBConnectionException {
        return repository.getAllEvents();
    }

    @Override
    public Event getEventDetails(int eventId) throws EventNotFoundException, DBConnectionException {
        return repository.getEventById(eventId);
    }

    @Override
    public void bookTicket(int eventId, Customer customer) throws EventNotFoundException, DBConnectionException {
        Event event = repository.getEventById(eventId);
        Booking booking = new Booking(0, customer, event); // bookingId = 0 (will be auto-incremented in DB)
        repository.bookEvent(booking);
    }

    @Override
    public void cancelBooking(int bookingId) throws BookingNotFoundException, DBConnectionException {
        repository.cancelBooking(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() throws DBConnectionException {
        return repository.getAllBookings();
    }

    @Override
    public Booking getBookingById(int bookingId) throws BookingNotFoundException, DBConnectionException {
        return repository.getBookingById(bookingId);
    }
}
