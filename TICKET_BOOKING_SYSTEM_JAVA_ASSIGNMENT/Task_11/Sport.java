package com.hexaware.tbs.task11;

public class Sport extends Event {
	private String sportName;
    private String teams;

    public Sport(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String sportName, String teams) {
        super(eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice);
        this.sportName = sportName;
        this.teams = teams;
    }

    // Getters and Setters
    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Sport Name: " + getEventName());
        System.out.println("Sport Type: " + sportName);
        System.out.println("Teams: " + teams);
    }

}
