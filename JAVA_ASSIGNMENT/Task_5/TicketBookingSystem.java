package com.hexaware.tbs.task5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.hexaware.tbs.task4.Event;

public class TicketBookingSystem {
	
	
	 public Event createEvent(String type) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("\nEnter Event Name:");
	        String name = sc.nextLine();
	        System.out.println("Enter Venue:");
	        String venue = sc.nextLine();
	        System.out.println("Enter Date (YYYY-MM-DD):");
	        LocalDate date = LocalDate.parse(sc.nextLine());
	        System.out.println("Enter Time (HH:MM):");
	        LocalTime time = LocalTime.parse(sc.nextLine());
	        System.out.println("Enter Total Seats:");
	        int seats = sc.nextInt();
	        System.out.println("Enter Ticket Price:");
	        double price = sc.nextDouble();
	        System.out.println("Enter Event Type");
	        String Type=sc.nextLine();
	        sc.nextLine(); // clear buffer

	        switch (type.toLowerCase()) {
	            case "movie":
	            {
	                System.out.println("Enter Genre:");
	                String genre = sc.nextLine();
	                System.out.println("Enter Actor Name:");
	                String actor = sc.nextLine();
	                System.out.println("Enter Actress Name:");
	                String actress = sc.nextLine();
	                return new Movie(name, date, time, venue, seats, price,type, genre, actor, actress);
	            }
	            case "concert":
	            {
	                System.out.println("Enter Artist Name:");
	                String artist = sc.nextLine();
	                System.out.println("Enter Type (Rock/Classical/Recital):");
	                String concertType = sc.nextLine();
	                return new Concert(name, date, time, venue, seats, price,type, artist, concertType);
	            }
	            case "sports":
	            {
	                System.out.println("Enter Sport Name:");
	                String sport = sc.nextLine();
	                System.out.println("Enter Teams (TeamA vs TeamB):");
	                String teams = sc.nextLine();
	                return new Sports(name, date, time, venue, seats, price, type,sport, teams);
	            }
	            default:
	            {
	                System.out.println("Invalid event type.");
	                return null;
	            }
	        }
	        
	    }

	    public void displayEventDetails(Event event) {
	        if (event != null) {
	            event.displayEventDetails();
	        }
	    }

	    public void bookTickets(Event event, int numTickets) {
	        if (event.getAvailableSeats() >= numTickets) {
	            event.setAvailableSeats(event.getAvailableSeats() - numTickets);
	            double cost = numTickets * event.getTicketPrice();
	            System.out.println("✅ Booking successful! Total Cost: ₹" + cost);
	        } else {
	            System.out.println("❌ Not enough tickets available. Only " + event.getAvailableSeats() + " left.");
	        }
	    }

	    public void cancelTickets(Event event, int numTickets) {
	        event.setAvailableSeats(event.getAvailableSeats() + numTickets);
	        System.out.println("🔄 " + numTickets + " tickets cancelled.");
	    }
	    
	    

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        TicketBookingSystem system = new TicketBookingSystem();
	        Event currentEvent = null;

	        while (true) {
	            System.out.println("\n===== Ticket Booking System =====");
	            System.out.println("1. Create Movie Event");
	            System.out.println("2. Create Concert Event");
	            System.out.println("3. Create Sports Event");
	            System.out.println("4. View Event Details");
	            System.out.println("5. Book Tickets");
	            System.out.println("6. Cancel Tickets");
	            System.out.println("7. Exit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); // clear buffer

	            switch (choice) {
	                case 1:
	                    currentEvent = system.createEvent("movie");
	                    break;
	                case 2:
	                    currentEvent = system.createEvent("concert");
	                    break;
	                case 3:
	                    currentEvent = system.createEvent("sports");
	                    break;
	                case 4:
	                    system.displayEventDetails(currentEvent);
	                    break;
	                case 5:
	                    System.out.println("Enter number of tickets to book:");
	                    int book = sc.nextInt();
	                    system.bookTickets(currentEvent, book);
	                    break;
	                case 6:
	                    System.out.println("Enter number of tickets to cancel:");
	                    int cancel = sc.nextInt();
	                    system.cancelTickets(currentEvent, cancel);
	                    break;
	                case 7:
	                    System.out.println("Thanks for using the system!");
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }

}
