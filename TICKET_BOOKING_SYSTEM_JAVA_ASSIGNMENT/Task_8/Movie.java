package com.hexaware.tbs.task8;

public class Movie extends Event {
    private String genre;
    private String actorName;
    private String actressName;

    // Default constructor
    public Movie() {
        super();
    }

    // Overloaded constructor
    public Movie(String eventName, String eventDate, String eventTime, Venue venue, 
                 int totalSeats, int availableSeats, double ticketPrice, String eventType, 
                 String genre, String actorName, String actressName) {
        super(eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice, eventType);
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

    // Method to display movie details
    public void displayEventDetails() {
        super.printEventDetails();
        System.out.println("Genre: " + genre);
        System.out.println("Actor Name: " + actorName);
        System.out.println("Actress Name: " + actressName);
    }
}