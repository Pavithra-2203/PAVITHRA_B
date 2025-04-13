package com.hexaware.tbs.task7;

import java.time.LocalDate;

public class Booking {

	private static int nextBookingID = 1; // Static to ensure global increment
    private int bookingID;
    private Customer[] customers;
    private Event event;
    private int numTickets;
    private double totalCost;
    private String bookingDate;

    // Constructor
    public Booking(Customer[] customers, Event event, int numTickets, double totalCost, String bookingDate) {
        if (numTickets > event.getAvailableSeats()) {
            throw new IllegalArgumentException("Number of tickets exceeds available seats.");
        }
        this.bookingID = nextBookingID++;
        this.customers = customers;
        this.event = event;
        this.numTickets = numTickets;
        this.totalCost = totalCost;
        this.bookingDate = bookingDate;

        // Update available seats in the event
        event.bookTickets(numTickets);
    }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Event Name: " + event.getEventName());
        System.out.println("Number of Tickets: " + numTickets);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Booking Date: " + bookingDate);
    }

    // Getters
    public int getBookingID() {
        return bookingID;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Event getEvent() {
        return event;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getBookingDate() {
        return bookingDate;
    }
}