package com.hexaware.tbs.task10;

import java.util.Set;

public class Booking {
	 private int bookingId;
	    private Set<Customer> customers;  // Set of customers to avoid duplicates
	    private Event event;
	    private int numTickets;
	    private double totalCost;

	    // Constructor
	    public Booking(Set<Customer> customers, Event event, int numTickets, double totalCost) {
	        this.bookingId = (int) (Math.random() * 10000);  // Generating a random booking ID
	        this.customers = customers;
	        this.event = event;
	        this.numTickets = numTickets;
	        this.totalCost = totalCost;
	    }

	    // Getters and Setters
	    public int getBookingId() {
	        return bookingId;
	    }

	    public Set<Customer> getCustomers() {
	        return customers;
	    }

	    public void setCustomers(Set<Customer> customers) {
	        this.customers = customers;
	    }

	    public Event getEvent() {
	        return event;
	    }

	    public void setEvent(Event event) {
	        this.event = event;
	    }

	    public int getNumTickets() {
	        return numTickets;
	    }

	    public void setNumTickets(int numTickets) {
	        this.numTickets = numTickets;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }

	    public void setTotalCost(double totalCost) {
	        this.totalCost = totalCost;
	    }
}
