package com.hexaware.tbs.task7;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {

	protected String eventName;
	protected String eventDate;
	protected String eventTime;
	protected String venueName;
	protected Venue venue;
	protected int totalSeats;
	protected int availableSeats;
	protected double ticketPrice;
	protected String eventType;

	    // Default Constructor
	    public Event() {
	    }

	    // Parameterized Constructor
	    public Event(String eventName, String eventDate, String eventTime, String venueName, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String eventType) {
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventTime = eventTime;
	        this.venueName = venueName;
	        this.venue = venue;
	        this.totalSeats = totalSeats;
	        this.availableSeats = availableSeats;
	        this.ticketPrice = ticketPrice;
	        this.eventType = eventType;
	    }

	    // Getters and Setters
	    public String getEventName() {
	        return eventName;
	    }

	    public void setEventName(String eventName) {
	        this.eventName = eventName;
	    }

	    public String getEventDate() {
	        return eventDate;
	    }

	    public void setEventDate(String eventDate) {
	        this.eventDate = eventDate;
	    }

	    public String getEventTime() {
	        return eventTime;
	    }

	    public void setEventTime(String eventTime) {
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

	    // Abstract Methods
	    public abstract double calculateTotalRevenue();

	    public abstract int getBookedNoOfTickets();

	    public abstract void bookTickets(int numTickets);

	    public abstract void cancelBooking(int numTickets);

	    public abstract void displayEventDetails();

	    // Override toString Method
	    @Override
	    public String toString() {
	        return "Event [eventName=" + eventName + ", eventDate=" + eventDate + ", eventTime=" + eventTime
	                + ", venueName=" + venueName + ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats
	                + ", ticketPrice=" + ticketPrice + ", eventType=" + eventType + "]";
	    }
	}
