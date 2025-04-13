package com.hexaware.tbs.task8.implementations;

import com.hexaware.tbs.task8.*;
import java.util.*;

public class BookingSystemServiceProviderImpl {

	private List<Event> events = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Event createEvent(String eventName, String eventDate, String eventTime,
                             int totalSeats, float ticketPrice, String eventType, Venue venue) {

        Event event = new Event(eventName, eventDate, eventTime, venue, totalSeats, totalSeats, ticketPrice, eventType);
        events.add(event);
        return event;
    }

    public Booking bookTickets(String eventName, int numTickets, Customer[] customersArray) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName) && event.getAvailableSeats() >= numTickets) {
                event.setAvailableSeats(event.getAvailableSeats() - numTickets);

                List<Customer> customers = Arrays.asList(customersArray);
                double totalCost = numTickets * event.getTicketPrice();

                
                Booking booking = new Booking(customers, event, numTickets, totalCost);

                bookings.add(booking);
                return booking;
            }
        }
        return null;
    }

    public void cancelBooking(String bookingIdStr) {
        int bookingId = Integer.parseInt(bookingIdStr);
        Booking toCancel = null;

        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                Event event = booking.getEvent();
                event.setAvailableSeats(event.getAvailableSeats() + booking.getNumTickets());
                toCancel = booking;
                break;
            }
        }

        if (toCancel != null) {
            bookings.remove(toCancel);
        }
    }

    public int getAvailableNumberOfTickets(String eventName) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event.getAvailableSeats();
            }
        }
        return 0;
    }

    public Event[] getEventDetails() {
        return events.toArray(new Event[0]);
    }

    public Booking getBookingDetails(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }
}

