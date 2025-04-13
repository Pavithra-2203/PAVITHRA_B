package com.hexaware.tbs.task6;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class BookingSystem {
	
	
	public abstract Event createEvent(String eventName, LocalDate eventDate, LocalTime eventTime, int totalSeats, int availableSeats,double ticketPrice, String venueName, String eventType);
    public abstract void displayEventDetails(Event event);
    public abstract double bookTickets(Event event, int numTickets);
    public abstract void cancelTickets(Event event, int numTickets);
    public abstract void updateEvent(int index, Event updatedEvent);
}
