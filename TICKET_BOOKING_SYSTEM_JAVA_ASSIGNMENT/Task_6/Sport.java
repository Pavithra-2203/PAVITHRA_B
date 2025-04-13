package com.hexaware.tbs.task6;


import com.hexaware.tbs.task6.Event;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sport extends Event{

	private String sportName;
    private String teamsName;

    public Sport() {
        super();
    }

    public Sport(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
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

    // Override display method
    @Override
    public void displayEventDetails() {
        System.out.println("\n===== Sports Event Details =====");
        System.out.println("Event Name     : " + eventName);
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Venue          : " + venueName);
        System.out.println("Sport          : " + sportName);
        System.out.println("Teams          : " + teamsName);
        System.out.println("Total Seats    : " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price   : ₹" + ticketPrice);
        System.out.println("Event Type     : " + eventType);
    }}
    
