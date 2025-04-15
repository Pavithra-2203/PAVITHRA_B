package com.hexaware.tbs.task11;

public class Concert extends Event {

	 private String artist;
	    private String concertType;

	    public Concert(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String artist, String concertType) {
	        super(eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice);
	        this.artist = artist;
	        this.concertType = concertType;
	    }

	    // Getters and Setters
	    public String getArtist() {
	        return artist;
	    }

	    public void setArtist(String artist) {
	        this.artist = artist;
	    }

	    public String getConcertType() {
	        return concertType;
	    }

	    public void setConcertType(String concertType) {
	        this.concertType = concertType;
	    }

	    @Override
	    public void displayEventDetails() {
	        System.out.println("Concert Name: " + getEventName());
	        System.out.println("Artist: " + artist);
	        System.out.println("Concert Type: " + concertType);
	    }
}
