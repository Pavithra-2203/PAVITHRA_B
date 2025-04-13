package com.hexaware.tbs.task8;

public class Sport extends Event {
    private String sportName;
    private String teamsName;

    // Default constructor
    public Sport() {
        super();
    }

    // Overloaded constructor
    public Sport(String eventName, String eventDate, String eventTime, Venue venue, 
                  int totalSeats, int availableSeats, double ticketPrice, String eventType, 
                  String sportName, String teamsName) {
        super(eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice, eventType);
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

    // Method to display sports details
    public void displayEventDetails() {
        super.printEventDetails();
        System.out.println("Sport Name: " + sportName);
        System.out.println("Teams Name: " + teamsName);
    }
}