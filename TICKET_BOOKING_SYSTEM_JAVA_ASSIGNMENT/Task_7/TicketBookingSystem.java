package com.hexaware.tbs.task7;

public class TicketBookingSystem extends BookingSystem{

	 @Override
	    public void getEventDetails() {
	        for (Event event : events) {
	            event.displayEventDetails();
	            System.out.println("--------------");
	        }
	    }
}
