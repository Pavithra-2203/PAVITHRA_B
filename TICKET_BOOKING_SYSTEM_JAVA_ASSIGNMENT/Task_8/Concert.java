package com.hexaware.tbs.task8;

import java.time.LocalDate;

public class Concert extends Event {
    private String artist;
    private String type;

    // Default constructor
    public Concert() {
        super();
    }

    // Overloaded constructor
    public Concert(String eventName, String eventDate, String eventTime, Venue venue, 
                   int totalSeats, int availableSeats, double ticketPrice, String eventType, 
                   String artist, String type) {
        super(eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice, eventType);
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

    // Method to display concert details
    public void displayEventDetails() {
        super.printEventDetails();
        System.out.println("Artist: " + artist);
        System.out.println("Type: " + type);
    }
}