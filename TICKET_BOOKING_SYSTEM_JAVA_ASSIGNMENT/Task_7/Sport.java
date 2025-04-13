package com.hexaware.tbs.task7;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sport extends Event {

	 private String sportName;
	    private String teamsName;

	    // Default Constructor
	    public Sport() {
	    }

	    // Parameterized Constructor
	    public Sport(String eventName, String eventDate, String eventTime, String venueName, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String eventType, String sportName, String teamsName) {
	        super(eventName, eventDate, eventTime, venueName, venue, totalSeats, availableSeats, ticketPrice, eventType);
	        this.sportName = sportName;
	        this.teamsName = teamsName;
	    }

	    // Getters and Setters
	    public String getSportName() {
	        return sportName;
	    }

	    public void setSportName(String sportName) {
	        this.sportName = sportName;
	    }

	    public String getTeamsName() {
	        return teamsName;
	    }

	    public void setTeamsName(String teamsName) {
	        this.teamsName = teamsName;
	    }

	    // Override toString Method
	    @Override
	    public String toString() {
	        return super.toString() + " Sports [sportName=" + sportName + ", teamsName=" + teamsName + "]";
	    }

	    // Display Event Details
	    @Override
	    public void displayEventDetails() {
	        System.out.println("Event Name: " + getEventName());
	        System.out.println("Event Date: " + getEventDate());
	        System.out.println("Event Time: " + getEventTime());
	        System.out.println("Venue Name: " + getVenueName());
	        System.out.println("Total Seats: " + getTotalSeats());
	        System.out.println("Available Seats: " + getAvailableSeats());
	        System.out.println("Ticket Price: $" + getTicketPrice());
	        System.out.println("Event Type: " + getEventType());
	        System.out.println("Sports [sportName=" + sportName + ", teamsName=" + teamsName + "]");
	    }

	    // Calculate Total Revenue
	    @Override
	    public double calculateTotalRevenue() {
	        return getTicketPrice() * (getTotalSeats() - getAvailableSeats());
	    }

	    // Get Booked Number of Tickets
	    @Override
	    public int getBookedNoOfTickets() {
	        return getTotalSeats() - getAvailableSeats();
	    }

	    // Book Tickets
	    @Override
	    public void bookTickets(int numTickets) {
	        if (numTickets <= getAvailableSeats()) {
	            setAvailableSeats(getAvailableSeats() - numTickets);
	            System.out.println(numTickets + " tickets booked successfully.");
	        } else {
	            System.out.println("Not enough available seats to book " + numTickets + " tickets.");
	        }
	    }

	    // Cancel Booking
	    @Override
	    public void cancelBooking(int numTickets) {
	        setAvailableSeats(getAvailableSeats() + numTickets);
	        System.out.println(numTickets + " tickets canceled successfully.");
	    }
	}
