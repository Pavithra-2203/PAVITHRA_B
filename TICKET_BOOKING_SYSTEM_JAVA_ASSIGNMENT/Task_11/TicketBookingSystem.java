package com.hexaware.tbs.task11;

import java.util.Scanner;

public class TicketBookingSystem {

	public static void main(String[] args) {
        BookingSystemRepositoryImpl bookingSystem = new BookingSystemRepositoryImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Ticket Booking System Menu ======");
            System.out.println("1. Create Event");
            System.out.println("2. Get Event Details");
            System.out.println("3. Get Available Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Event Name: ");
                        String eventName = sc.nextLine();
                        System.out.print("Enter Event Date (YYYY-MM-DD): ");
                        String eventDate = sc.nextLine();
                        System.out.print("Enter Event Time (HH:MM): ");
                        String eventTime = sc.nextLine();
                        System.out.print("Enter Total Seats: ");
                        int totalSeats = sc.nextInt();
                        System.out.print("Enter Ticket Price: ");
                        double ticketPrice = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Event Type (Movie/Sports/Concert): ");
                        String eventType = sc.nextLine();
                        System.out.print("Enter Venue Name: ");
                        String venueName = sc.nextLine();
                        System.out.print("Enter Venue Address: ");
                        String venueAddress = sc.nextLine();

                        Venue venue = new Venue(venueName, venueAddress);
                        bookingSystem.createEvent(eventName, eventDate, eventTime, totalSeats, ticketPrice, eventType, venue);
                        break;

                    case 2:
                        System.out.println("Event Details:");
                        for (Event event : bookingSystem.getEventDetails()) {
                            event.displayEventDetails();
                        }
                        break;

                    case 3:
                        System.out.println("Available Tickets: " + bookingSystem.getAvailableNoOfTickets());
                        break;

                    case 4:
                        System.out.println("Exiting Ticket Booking System. Goodbye!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
