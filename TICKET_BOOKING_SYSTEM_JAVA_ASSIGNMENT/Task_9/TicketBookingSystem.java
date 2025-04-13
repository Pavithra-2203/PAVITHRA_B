package com.hexaware.tbs.task9;

import java.util.Scanner;

public class TicketBookingSystem {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n====== Ticket Booking System Menu ======");
                System.out.println("1. Book Tickets");
                System.out.println("2. Cancel Tickets");
                System.out.println("3. View Booking Details");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Event Name: ");
                        String eventName = sc.nextLine();
                        if (!eventExists(eventName)) {
                            throw new EventNotFoundException("Event not found: " + eventName);
                        }
                        System.out.println("Tickets booked successfully for event: " + eventName);
                        break;

                    case 2:
                        System.out.print("Enter Booking ID to cancel: ");
                        int bookingId = sc.nextInt();
                        if (!isValidBookingId(bookingId)) {
                            throw new InvalidBookingIDException("Invalid Booking ID: " + bookingId);
                        }
                        System.out.println("Booking canceled successfully for ID: " + bookingId);
                        break;

                    case 3:
                        System.out.print("Enter Booking ID to view details: ");
                        int viewBookingId = sc.nextInt();
                        if (!isValidBookingId(viewBookingId)) {
                            throw new InvalidBookingIDException("Invalid Booking ID: " + viewBookingId);
                        }
                        System.out.println("Displaying booking details for ID: " + viewBookingId);
                        break;

                    case 4:
                        System.out.println("Exiting Ticket Booking System. Goodbye!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidBookingIDException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Null value encountered.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static boolean eventExists(String eventName) {
        // Simulate event existence check
        return false; // Change this logic as needed
    }

    private static boolean isValidBookingId(int bookingId) {
        // Simulate booking ID validation
        return false; // Change this logic as needed
    }
}
