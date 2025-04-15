package com.hexaware.tbs.task11;

public class Movie extends Event {

	private String genre;
    private String actorName;
    private String actressName;

    public Movie(String eventName, String eventDate, String eventTime, Venue venue, int totalSeats, int availableSeats, double ticketPrice, String genre, String actorName, String actressName) {
        super(eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice);
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

    @Override
    public void displayEventDetails() {
        System.out.println("Movie Name: " + getEventName());
        System.out.println("Genre: " + genre);
        System.out.println("Actor: " + actorName);
        System.out.println("Actress: " + actressName);
    }
}
