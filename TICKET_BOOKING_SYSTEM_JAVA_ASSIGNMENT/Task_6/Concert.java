package com.hexaware.tbs.task6;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.tbs.task6.Event;

public class Concert extends Event {
	private String artist;
    private String type; // Theatrical, Classical, Rock, Recital

    public Concert() {
        super();
    }

    public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
                   int totalSeats, double ticketPrice, String eventType,
                   String artist, String type) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, eventType);
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

    // Override display method
    @Override
    public void displayEventDetails() {
        System.out.println("\n===== Concert Details =====");
        System.out.println("Event Name     : " + eventName);
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Venue          : " + venueName);
        System.out.println("Artist         : " + artist);
        System.out.println("Concert Type   : " + type);
        System.out.println("Total Seats    : " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price   : ₹" + ticketPrice);
        System.out.println("Event Type     : " + eventType);
    }
}
