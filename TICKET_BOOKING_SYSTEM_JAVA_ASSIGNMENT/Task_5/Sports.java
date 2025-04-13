package com.hexaware.tbs.task5;

import java.time.LocalDate;

import java.time.LocalTime;

import com.hexaware.tbs.task4.Event;

public class Sports extends Event {
	private String sportName;
    private String teamsName;

    // Default constructor
    public Sports() {
        
    }

    // Parameterized constructor
    public Sports(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
                  int totalSeats, double ticketPrice, String eventType,
                  String sportName, String teamsName) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, eventType);
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

    // Overridden method to display event details
    @Override
    public void displayEventDetails() {
        System.out.println("\n Sports Event Details:");
        System.out.println("Event Name: " + getEventName());
        System.out.println("Match: " + sportName + " | Teams: " + teamsName);
        System.out.println("Date: " + getEventDate() + ", Time: " + getEventTime());
        System.out.println("Venue: " + getVenueName());
        System.out.println("Ticket Price: ₹" + getTicketPrice());
        System.out.println("Seats Available: " + getAvailableSeats());
    }
}