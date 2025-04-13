package com.hexaware.tbs.task10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        BookingSystem bookingSystem = new BookingSystem();
        Set<Customer> customers = new HashSet<>();

        System.out.println("===== Add Events =====");
        System.out.print("How many events do you want to add? ");
        int numEvents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numEvents; i++) {
            System.out.println("Enter details for Event " + (i + 1));
            System.out.print("Event ID: ");
            int eventId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Event Name: ");
            String eventName = scanner.nextLine();

            System.out.print("Event Location: ");
            String location = scanner.nextLine();

            Event event = new Event(eventId, eventName, location);
            bookingSystem.addEvent(event);
        }

        System.out.println("\n===== Events Added =====");
        bookingSystem.listEvents();

        System.out.println("\n===== Add Customers =====");
        System.out.print("How many customers do you want to add? ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numCustomers; i++) {
            System.out.println("Enter details for Customer " + (i + 1));
            System.out.print("Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();

            Customer customer = new Customer(customerId, customerName);
            customers.add(customer);
        }

        System.out.println("\n===== Booking =====");
        System.out.print("Enter Event ID to book: ");
        int bookEventId = scanner.nextInt();

        Event selectedEvent = bookingSystem.getEventById(bookEventId);
        if (selectedEvent == null) {
            System.out.println("Event not found!");
            return;
        }

        System.out.print("Enter number of tickets: ");
        int numTickets = scanner.nextInt();

        double pricePerTicket = 100.0;  // Example price
        double totalCost = numTickets * pricePerTicket;

        Booking booking = new Booking(customers, selectedEvent, numTickets, totalCost);

        System.out.println("\n===== Booking Details =====");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Event: " + booking.getEvent().getName() + " at " + booking.getEvent().getLocation());
        System.out.println("Customers: ");
        for (Customer c : booking.getCustomers()) {
            System.out.println("- " + c.getName());
        }
        System.out.println("Number of Tickets: " + booking.getNumTickets());
        System.out.println("Total Cost: ₹" + booking.getTotalCost());

        scanner.close();
    }
}
