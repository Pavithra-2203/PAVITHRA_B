package com.hexaware.tbs.task4;

public class Booking {
	
	 private Event event;
	    private Customer customer;
	    private double totalCost;

	    public Booking(Event event, Customer customer) {
	        this.event = event;
	        this.customer = customer;
	    }

	    public boolean bookTickets(int numTickets) {
	        if (event.bookTickets(numTickets)) {
	            calculateBookingCost(numTickets);
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public void cancelBooking(int numTickets) {
	        event.cancelBooking(numTickets);
	        System.out.println(numTickets + " tickets cancelled.");
	    }

	    public void calculateBookingCost(int numTickets) {
	        this.totalCost = numTickets * event.getTicketPrice();
	    }

	    public int getAvailableNoOfTickets() {
	        return event.getAvailableSeats();
	    }

	    public void getEventDetails() {
	        event.displayEventDetails();
	    }

	    public void displayBookingDetails() {
	        System.out.println("\n--- Booking Summary ---");
	        customer.displayCustomerDetails();
	        event.displayEventDetails();
	        System.out.println("Total Cost: ₹" + totalCost);
	    }

		

}
