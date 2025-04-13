package com.hexaware.tbs.task8;

import com.hexaware.tbs.task8.services.EventService;
import com.hexaware.tbs.task8.Customer;
import com.hexaware.tbs.task8.implementations.BookingSystemServiceProviderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        BookingSystemServiceProviderImpl bookingSystem = new BookingSystemServiceProviderImpl();

	        System.out.println("Welcome to the ticketBookingSystem");

	        while (true) {
	            System.out.println("\nAvailable commands:");
	            System.out.println("1. createEvent");
	            System.out.println("2. bookTickets");
	            System.out.println("3. cancelTickets");
	            System.out.println("4. getAvailableSeats");
	            System.out.println("5. getEventDetails");
	            System.out.println("6. exit");

	            System.out.print("\nEnter command: ");
	            String command = scanner.nextLine().trim().toLowerCase();

	            switch (command) {
	                case "createevent":
	                    System.out.print("Enter eventName: ");
	                    String eventName = scanner.nextLine();

	                    System.out.print("Enter eventDate (YYYY-MM-DD): ");
	                    String eventDate = scanner.nextLine();

	                    System.out.print("Enter eventTime (HH:MM): ");
	                    String eventTime = scanner.nextLine();

	                    System.out.print("Enter totalSeats: ");
	                    int totalSeats = Integer.parseInt(scanner.nextLine());

	                    System.out.print("Enter ticketPrice: ");
	                    float ticketPrice = Float.parseFloat(scanner.nextLine());

	                    System.out.print("Enter eventType (movie/sports/concert): ");
	                    String eventType = scanner.nextLine();
	                 
	                    System.out.print("Enter venueId: ");
	                    int venueId = scanner.nextInt();
	                    
	                    System.out.print("Enter venueName: ");
	                    String venueName = scanner.nextLine();
	                    scanner.next();

	                    
	                    System.out.print("Enter venueLocation: ");
	                    String venueLocation = scanner.nextLine();

	                    Venue venue = new Venue( venueId,venueName, venueLocation);
	                    Event event = bookingSystem.createEvent(eventName, eventDate, eventTime, totalSeats, ticketPrice, eventType, venue);

	                    System.out.println("\nEvent created successfully:\n" );
	                    break;

	                case "booktickets":
	                    System.out.print("Enter eventName: ");
	                    String eventNameToBook = scanner.nextLine();

	                    System.out.print("Enter numberOfTickets: ");
	                    int numberOfTickets = Integer.parseInt(scanner.nextLine());

	                    Customer[] customers = new Customer[numberOfTickets];

	                    for (int i = 0; i < numberOfTickets; i++) {
	                        System.out.println("Enter details for customer " + (i + 1));
	                        
	                        System.out.println("Enter customerId");
	                        int customerId=scanner.nextInt();
	                        
	                        System.out.print("Enter customerName: ");
	                        String customerName = scanner.nextLine();
                            scanner.next();
	                        System.out.print("Enter customerEmail: ");
	                        String customerEmail = scanner.nextLine();

	                        customers[i] = new Customer(customerId,customerName, customerEmail);
	                    }

	                    Booking booking = bookingSystem.bookTickets(eventNameToBook, numberOfTickets, customers);

	                    if (booking != null) {
	                        System.out.println("\nBooking successful! bookingId: " + booking.getBookingId());
	                    } else {
	                        System.out.println("\nBooking failed. Check eventName or ticket availability.");
	                    }
	                    break;

	                case "canceltickets":
	                    System.out.print("Enter bookingId to cancel: ");
	                    String bookingId = scanner.nextLine();

	                    bookingSystem.cancelBooking(bookingId);
	                    System.out.println("Booking canceled successfully.");
	                    break;

	                case "getavailableseats":
	                    System.out.print("Enter eventName: ");
	                    String eventNameToCheck = scanner.nextLine();

	                    int availableSeats = bookingSystem.getAvailableNumberOfTickets(eventNameToCheck);
	                    System.out.println("Available tickets: " + availableSeats);
	                    break;

	                case "geteventdetails":
	                    Event[] allEvents = bookingSystem.getEventDetails();

	                    if (allEvents.length == 0) {
	                        System.out.println("No events available.");
	                    } else {
	                        System.out.println("\nEvent details:");
	                        for (Event ev : allEvents) {
	                            System.out.println(ev);
	                        }
	                    }
	                    break;

	                case "exit":
	                    System.out.println("Thank you for using the ticketBookingSystem. Goodbye!");
	                    return;

	                default:
	                    System.out.println("Invalid command. Please try again.");
	            }
	        }
	    }
}
