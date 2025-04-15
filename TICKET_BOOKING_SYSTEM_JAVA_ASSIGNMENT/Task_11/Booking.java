package com.hexaware.tbs.task11;

import java.util.List;

public class Booking {

	 private static int nextBookingId = 1;
	    private int bookingId;
	    private List<Customer> customers;
	    private Event event;
	    private int numTickets;
	    private double totalCost;

	    public Booking(List<Customer> customers, Event event, int numTickets, double totalCost) {
	        this.bookingId = nextBookingId++;
	        this.customers = customers;
	        this.event = event;
	        this.numTickets = numTickets;
	        this.totalCost = totalCost;
	    }
	    public int getBookingId() {
	        return bookingId;
	    }

	    public List<Customer> getCustomers() {
	        return customers;
	    }

	    public void setCustomers(List<Customer> customers) {
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
