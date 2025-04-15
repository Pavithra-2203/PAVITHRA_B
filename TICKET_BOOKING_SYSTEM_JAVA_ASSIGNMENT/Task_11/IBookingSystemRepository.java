package com.hexaware.tbs.task11;

import java.util.List;

public interface IBookingSystemRepository {
	 Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue);
	    List<Event> getEventDetails();
	    int getAvailableNoOfTickets();
	    double calculateBookingCost(int numTickets);
	    void bookTickets(String eventName, int numTickets, List<Customer> customers);
	    void cancelBooking(int bookingId);
	    Booking getBookingDetails(int bookingId);
}
