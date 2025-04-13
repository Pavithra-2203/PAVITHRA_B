package com.hexaware.tbs.task4;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	
	 

	    protected String eventName;
	    protected LocalDate eventDate;
	    protected LocalTime eventTime;
	    protected String venueName;
	    protected int totalSeats;
	    protected int availableSeats;
	    protected double ticketPrice;
	    protected String eventType;

	    // Default constructor
	    public Event() 
	    {
	    	
	    }

	    // Parameterized constructor
	    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
	                 int totalSeats, double ticketPrice, String eventType)
	    {
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventTime = eventTime;
	        this.venueName = venueName;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        this.ticketPrice = ticketPrice;
	        this.eventType = eventType;
	    }

	    // Getters & Setters

	    public String getEventName() {
			return eventName;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public LocalDate getEventDate() {
			return eventDate;
		}

		public void setEventDate(LocalDate eventDate) {
			this.eventDate = eventDate;
		}

		public LocalTime getEventTime() {
			return eventTime;
		}

		public void setEventTime(LocalTime eventTime) {
			this.eventTime = eventTime;
		}

		public String getVenueName() {
			return venueName;
		}

		public void setVenueName(String venueName) {
			this.venueName = venueName;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}

		public double getTicketPrice() {
			return ticketPrice;
		}

		public void setTicketPrice(double ticketPrice) {
			this.ticketPrice = ticketPrice;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
		
		 // Method: Calculate total revenue
	    public double calculateTotalRevenue() {
	        return (totalSeats - availableSeats) * ticketPrice;
	    }

		// Method: Get booked tickets
	    public int getBookedNoOfTickets() {
	        return totalSeats - availableSeats;
	    }

	    // Book tickets
	    public boolean bookTickets(int numTickets) {
	        if (numTickets <= availableSeats) {
	            availableSeats -= numTickets;
	            return true;
	        }
	        return false;
	    }

	    // Cancel booking
	    public void cancelBooking(int numTickets) {
	        availableSeats += numTickets;
	    }

	    // Display event details
	    public void displayEventDetails() {
	        System.out.println("\n--- Event Details ---");
	        System.out.println("Name: " + eventName);
	        System.out.println("Date: " + eventDate);
	        System.out.println("Time: " + eventTime);
	        System.out.println("Venue: " + venueName);
	        System.out.println("Event Type: " + eventType);
	        System.out.println("Total Seats: " + totalSeats);
	        System.out.println("Available Seats: " + availableSeats);
	        System.out.println("Ticket Price: ₹" + ticketPrice);
	    }

}
