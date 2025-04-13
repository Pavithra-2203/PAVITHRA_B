package com.hexaware.tbs.task7;

public class Venue {
	
	private String venueName;  
    private String address;

    // Getters and Setters
    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Default Constructor
    public Venue() {
    }

    // Parameterized Constructor
    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

    // Display Venue Details
    public void displayVenueDetails() {
        System.out.println("Venue Name: " + venueName);
        System.out.println("Address: " + address);
    }
}
