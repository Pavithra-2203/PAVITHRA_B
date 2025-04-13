package com.hexaware.tbs.task7;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.tbs.task7.*;


public class Movie extends Event {
	
	private String genre;
    private String actorName;
    private String actressName;

    // Default Constructor
    public Movie() {
    }

    // Parameterized Constructor
    public Movie(String eventName, String eventDate, String eventTime, String venueName, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String eventType, String genre, String actorName, String actressName) {
        super(eventName, eventDate, eventTime, venueName, venue, totalSeats, availableSeats, ticketPrice, eventType);
        this.genre = genre;
        this.actorName = actorName;
        this.actressName = actressName;
    }

    // Getters and Setters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActressName() {
        return actressName;
    }

    public void setActressName(String actressName) {
        this.actressName = actressName;
    }

    // Override toString Method
    @Override
    public String toString() {
        return super.toString() + " Movie [genre=" + genre + ", actorName=" + actorName + ", actressName=" + actressName + "]";
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
        System.out.println("Movie [genre=" + genre + ", actorName=" + actorName + ", actressName=" + actressName + "]");
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


