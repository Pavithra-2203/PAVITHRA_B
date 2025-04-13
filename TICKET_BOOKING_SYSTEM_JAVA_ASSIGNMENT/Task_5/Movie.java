package com.hexaware.tbs.task5;

import java.time.LocalDate;

import java.time.LocalTime;

import com.hexaware.tbs.task4.Event;

public class Movie extends Event{
	
	 private String genre;
	 private String actorName;
	 private String actressName;
	
	 
	 public Movie() 
	 {
		 
	 }
	 
	 public Movie(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats,
             double ticketPrice, String eventType,String genre, String actorName, String actressName) 
	 {
    super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, eventType);
    this.genre = genre;
    this.actorName = actorName;
    this.actressName = actressName;
     }

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
	        System.out.println("\n Movie Event");
	        System.out.println("Name: " + eventName + ", Date: " + eventDate + ", Time: " + eventTime);
	        System.out.println("Genre: " + genre + ", Actor: " + actorName + ", Actress: " + actressName);
	        System.out.println("Venue: " + venueName + ", Price: ₹" + ticketPrice + ", Seats Available: " + availableSeats);
	    } 
	 

}
