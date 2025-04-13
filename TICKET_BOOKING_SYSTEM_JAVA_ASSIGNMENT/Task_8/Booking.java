package com.hexaware.tbs.task8;

import com.hexaware.tbs.task8.Event;   // Use task8 version of Event
import com.hexaware.tbs.task4.Customer; // Use task4 version of Customer

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {
	private static final AtomicInteger idCounter = new AtomicInteger(1000);  // Booking ID starts from 1000
    private int bookingId;
    private List<Customer> customers; // List of customers in this booking
    private Event event;              // The event this booking is associated with
    private int numTickets;           // Number of tickets in the booking
    private double totalCost;         // Total cost of the booking

    // ✅ Constructor to initialize the Booking object with auto-generated bookingId
    public Booking(List<Customer> customers, Event event, int numTickets, double totalCost) {
        this.bookingId = idCounter.getAndIncrement();  // Auto-generate booking ID
        this.customers = customers;
        this.event = event;
        this.numTickets = numTickets;
        this.totalCost = totalCost;
    }

    // Getters and Setters
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
