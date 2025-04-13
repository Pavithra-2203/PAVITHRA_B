package com.hexaware.tbs.task6;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.tbs.task6.Event;

public class Movie extends Event{
	
	private String genre;
    private String actorName;
    private String actressName;

    public Movie() {
        super();
    }

    public Movie(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
                 int totalSeats, double ticketPrice, String eventType,
                 String genre, String actorName, String actressName) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, eventType);
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

    // Override display method
    @Override
    public void displayEventDetails() {
        System.out.println("\n===== Movie Details =====");
        System.out.println("Event Name     : " + eventName);
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Venue          : " + venueName);
        System.out.println("Genre          : " + genre);
        System.out.println("Actor          : " + actorName);
        System.out.println("Actress        : " + actressName);
        System.out.println("Total Seats    : " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price   : ₹" + ticketPrice);
        System.out.println("Event Type     : " + eventType);
    }

}
