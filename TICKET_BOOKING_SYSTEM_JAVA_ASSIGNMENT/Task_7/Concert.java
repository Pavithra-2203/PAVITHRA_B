package com.hexaware.tbs.task7;
import java.time.LocalDate;

import java.time.LocalTime;

import com.hexaware.tbs.task7.*;
public class Concert extends Event {

	 private String artist;
	    private String type;

	    // Default Constructor
	    public Concert() {
	        this.artist = "Anirudh";
	        this.type = "Music";
	    }

	    // Parameterized Constructor
	    public Concert(String eventName, String eventDate, String eventTime, String venueName, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String eventType, String artist, String type) {
	        super(eventName, eventDate, eventTime, venueName, venue, totalSeats, availableSeats, ticketPrice, eventType);
	        this.artist = artist;
	        this.type = type;
	    }

	    // Getters and Setters
	    public String getArtist() {
	        return artist;
	    }

	    public void setArtist(String artist) {
	        this.artist = artist;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    // Override toString Method
	    @Override
	    public String toString() {
	        return super.toString() + "Concert [artist=" + artist + ", type=" + type + "]";
	    }

	    // Display Event Details
	    @Override
	    public void displayEventDetails() {
	        System.out.println("Event Name: " + eventName);
	        System.out.println("Event Date: " + eventDate);
	        System.out.println("Event Time: " + eventTime);
	        System.out.println("Venue Name: " + venueName);
	        System.out.println("Total Seats: " + totalSeats);
	        System.out.println("Available Seats: " + availableSeats);
	        System.out.println("Ticket Price: $" + ticketPrice);
	        System.out.println("Event Type: " + eventType);
	        System.out.println("Concert [artist=" + artist + ", type=" + type + "]");
	    }

	    // Calculate Total Revenue
	    @Override
	    public double calculateTotalRevenue() {
	        return ticketPrice * (totalSeats - availableSeats);
	    }

	    // Get Booked Number of Tickets
	    @Override
	    public int getBookedNoOfTickets() {
	        return totalSeats - availableSeats;
	    }

	    // Book Tickets
	    @Override
	    public void bookTickets(int numTickets) {
	        if (numTickets <= availableSeats) {
	            availableSeats -= numTickets;
	            System.out.println(numTickets + " tickets booked successfully.");
	        } else {
	            System.out.println("Not enough available seats to book " + numTickets + " tickets.");
	        }
	    }

	    // Cancel Booking
	    @Override
	    public void cancelBooking(int numTickets) {
	        availableSeats += numTickets;
	        System.out.println(numTickets + " tickets canceled successfully.");
	    }

	}

	

