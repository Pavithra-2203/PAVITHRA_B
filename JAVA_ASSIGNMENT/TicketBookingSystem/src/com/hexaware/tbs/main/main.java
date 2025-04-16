package com.hexaware.tbs.main;

import java.util.*;
import com.hexaware.tbs.entity.*;
import com.hexaware.tbs.exception.*;
import com.hexaware.tbs.service.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IBookingService service = new BookingServiceImpl();

        while (true) {
            System.out.println("\n--- Ticket Booking System ---");
            System.out.println("1. Create Event");
            System.out.println("2. View All Events");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View All Bookings");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Event Name: ");
                        String name = sc.nextLine();

                        String type;
                        while (true) {
                            System.out.print("Type (movie/concert/sports): ");
                            type = sc.nextLine().toLowerCase();
                            if (type.equals("movie") || type.equals("concert") || type.equals("sports")) {
                                break;
                            } else {
                                System.out.println("Invalid type. Please enter 'movie', 'concert', or 'sports'.");
                            }
                        }

                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Venue: ");
                        String venue = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine(); // Consume the newline character

                        Event event;
                        if (type.equals("movie")) {
                            System.out.print("Genre: ");
                            String genre = sc.nextLine();
                            System.out.print("Director: ");
                            String director = sc.nextLine();
                            event = new Movie(0, name, date, venue, price, genre, director); // ID is set to 0 for new events
                        } else if (type.equals("concert")) {
                            System.out.print("Performer: ");
                            String performer = sc.nextLine();
                            event = new Concert(0, name, date, venue, price, performer); // ID is set to 0 for new events
                        } else {
                            System.out.print("Team: ");
                            String team = sc.nextLine();
                            event = new Sports(0, name, date, venue, price, team); // ID is set to 0 for new events
                        }

                        service.createEvent(event);
                        System.out.println("Event created.");
                        break;

                    case 2:
                        for (Event e : service.listAllEvents()) {
                            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getType());
                        }
                        break;

                    case 3:
                        System.out.print("Event ID: ");
                        int eventId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Customer Name: ");
                        String cname = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Contact: ");
                        String contact = sc.nextLine();
                        Customer customer = new Customer(cname, email, contact);
                        service.bookTicket(eventId, customer);
                        System.out.println("Ticket booked.");
                        break;

                    case 4:
                        System.out.print("Booking ID: ");
                        int bookingId = sc.nextInt();
                        service.cancelBooking(bookingId);
                        System.out.println("Booking canceled.");
                        break;

                    case 5:
                        for (Booking b : service.getAllBookings()) {
                            System.out.println("Booking ID: " + b.getId() + " | Customer: " + b.getCustomer().getName() + " | Event: " + b.getEvent().getName());
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (DBConnectionException e) {
                System.err.println("Database connection error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
