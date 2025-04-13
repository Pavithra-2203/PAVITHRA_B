package com.hexaware.tbs.task4;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		
		
		 // Create Venue
        Venue venue = new Venue("Chennai Arena", "Anna Salai, Chennai");
        venue.displayVenueDetails();

        // Create Event
        Event event = new Event("AR Rahman Live", LocalDate.of(2025, 5, 1), LocalTime.of(18, 30),
                venue.getVenueName(), 100, 2000.0,"CONCERT");

        // Create Customer
        Customer customer = new Customer("Pavithra", "pavi@example.com", "9876543210");

        // Create Booking
        Booking booking = new Booking(event, customer);

        // Book tickets
        if (booking.bookTickets(3)) {
            System.out.println("\n✅ Booking Successful!");
        } else {
            System.out.println("\n❌ Booking Failed! Not enough seats.");
        }

        // Display booking info
        booking.displayBookingDetails();
        System.out.println();

        // Cancel 1 ticket
        booking.cancelBooking(1);

        // Display updated event details
        booking.getEventDetails();
    

	}

}
