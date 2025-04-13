package com.hexaware.tbs.task8.services;

import com.hexaware.tbs.task8.Booking;

public interface BookingService {
	double calculateBookingCost(int numTickets, double ticketPrice);
    void bookTickets(Booking booking);
    void cancelBooking(int bookingId);
    Booking getBookingDetails(int bookingId);
}