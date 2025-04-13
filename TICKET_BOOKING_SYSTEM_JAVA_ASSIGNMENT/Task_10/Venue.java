package com.hexaware.tbs.task10;

public class Venue {
	private String venueName;
    private String address;

    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

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
}
	 
