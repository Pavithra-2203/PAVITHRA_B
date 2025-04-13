package com.hexaware.tbs.task5;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.tbs.task4.Event;

public class Concert extends Event {
	
	private String artist;
    private String type;

    public Concert() {}

    public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats,
                   double ticketPrice, String eventType, String artist, String type) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice,eventType);
        this.artist = artist;
        this.type = type;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("\n Concert Event");
        System.out.println("Name: " + eventName + ", Date: " + eventDate + ", Time: " + eventTime);
        System.out.println("Artist: " + artist + ", Type: " + type);
        System.out.println("Venue: " + venueName + ", Price: ₹" + ticketPrice + ", Seats Available: " + availableSeats);
    }

}
