package com.hexaware.tbs.task6;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
	
	protected String eventName;
    protected LocalDate date;
    protected LocalTime time;
    protected String venueName;
    protected int totalSeats;
    protected int availableSeats;
    protected double ticketPrice;
    protected String eventType;

    public Event() {}

    public Event(String eventName, LocalDate date, LocalTime time, String venueName,
                 int totalSeats, double ticketPrice, String eventType) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initial availability = total
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }

    // Getters and Setters
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public String getVenueName() { return venueName; }
    public void setVenueName(String venueName) { this.venueName = venueName; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { 
        this.totalSeats = totalSeats;
        if (availableSeats > totalSeats) availableSeats = totalSeats; 
    }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    // Utility Methods
    public boolean updateSeats(int num) {
        if (availableSeats + num >= 0 && availableSeats + num <= totalSeats) {
            availableSeats += num;
            return true;
        } else {
            System.out.println("⚠️ Invalid seat update. Please check the number of tickets.");
            return false;
        }
    }

    public int getBookedNoOfTickets() {
        return totalSeats - availableSeats;
    }

    public double calculateTotalRevenue() {
        return getBookedNoOfTickets() * ticketPrice;
    }

    public void bookTickets(int numTickets) {
        if (numTickets <= 0) {
            System.out.println("⚠️ Number of tickets must be greater than 0.");
        } else if (availableSeats >= numTickets) {
            availableSeats -= numTickets;
        } else {
            System.out.println("⚠️ Not enough seats available.");
        }
    }

    public void cancelBooking(int numTickets) {
        if (numTickets <= 0) {
            System.out.println("⚠ Number of tickets must be greater than 0.");
        } else if ((availableSeats + numTickets) <= totalSeats) {
            availableSeats += numTickets;
        } else {
            System.out.println(" Cannot cancel more tickets than booked.");
        }
    }

    // Abstract method to be implemented in subclasses
    public abstract void displayEventDetails();
}


