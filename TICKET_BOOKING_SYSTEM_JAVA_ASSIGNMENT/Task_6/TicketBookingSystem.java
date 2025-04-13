package com.hexaware.tbs.task6;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import com.hexaware.tbs.task6.*;
public class TicketBookingSystem extends BookingSystem  {
              
	List<Event> events = new ArrayList<>();

    @Override
    public Event createEvent(String eventName, LocalDate eventDate, LocalTime eventTime, int totalSeats, int availableSeats, double ticketPrice, String venueName, String eventType) {
        Scanner sc = new Scanner(System.in);
        Event event = null;
        switch (eventType.toLowerCase()) {
            case "movie":
                System.out.print("Enter Genre: ");
                String genre = sc.nextLine();
                System.out.print("Enter Actor Name: ");
                String actor = sc.nextLine();
                System.out.print("Enter Actress Name: ");
                String actress = sc.nextLine();
                event = new Movie(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice,eventType, genre, actor, actress);
                break;
            case "concert":
                System.out.print("Enter Artist: ");
                String artist = sc.nextLine();
                System.out.print("Enter Concert Type: ");
                String type = sc.nextLine();
                event = new Concert(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice,eventType, artist, type);
                break;
            case "sport":
                System.out.print("Enter Sport Name: ");
                String sportName = sc.nextLine();
                System.out.print("Enter Teams: ");
                String teams = sc.nextLine();
                event = new Sport(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice,eventType, sportName, teams);
                break;
        }
        if (event != null) events.add(event);
        return event;
    }

    @Override
    public void updateEvent(int index, Event updatedEvent) {
        if (index >= 0 && index < events.size()) {
            events.set(index, updatedEvent);
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }

    @Override
    public void displayEventDetails(Event event) {
        event.displayEventDetails();
    }

    @Override
    public double bookTickets(Event event, int numTickets) {
        if (event.updateSeats(-numTickets)) {
            double cost = numTickets * event.ticketPrice;
            System.out.println("Tickets booked! Total cost: ₹" + cost);
            return cost;
        } else {
            System.out.println("Not enough seats available!");
            return 0;
        }
    }

    @Override
    public void cancelTickets(Event event, int numTickets) {
        event.updateSeats(numTickets);
        System.out.println(numTickets + " tickets cancelled successfully.");
    }

    public void runSystem() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions: createEvent, updateEvent, bookTickets, cancelTickets, getAvailableSeats, exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();
            switch (choice.toLowerCase()) {
            case "createevent":
                System.out.print("Event Name: ");
                String name = sc.nextLine();
                System.out.print("Date (yyyy-mm-dd): ");
                LocalDate date = LocalDate.parse(sc.nextLine());
                System.out.print("Time (HH:mm): ");
                LocalTime time = LocalTime.parse(sc.nextLine());
                System.out.print("Venue Name: ");
                String venue = sc.nextLine();
                System.out.print("Total Seats: ");
                int seats = Integer.parseInt(sc.nextLine());
                System.out.print("Available Seats: ");
                int aseats = Integer.parseInt(sc.nextLine());
                System.out.print("Ticket Price: "); // Add this prompt
                double price = Double.parseDouble(sc.nextLine()); // Ensure input is read
                System.out.print("Event Type (movie/concert/sport): ");
                String type = sc.nextLine();
                Event event = createEvent(name, date, time, seats, aseats, price, venue, type);
                System.out.println("Event created successfully.");
                break;
                case "updateevent":
                    displayEvents();
                    System.out.print("Enter index of event to update: ");
                    int updateIndex = Integer.parseInt(sc.nextLine());
                    System.out.print("Event Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Date (yyyy-mm-dd): ");
                    LocalDate newDate = LocalDate.parse(sc.nextLine());
                    System.out.print("Time (HH:mm): ");
                    LocalTime newTime = LocalTime.parse(sc.nextLine());
                    System.out.print("Venue Name: ");
                    String newVenue = sc.nextLine();
                    System.out.print("Total Seats: ");
                    int newSeats = Integer.parseInt(sc.nextLine());
                    System.out.print("available Seats: ");
                    int aSeats = Integer.parseInt(sc.nextLine());
                    System.out.print("Ticket Price: ");
                    double newPrice = Double.parseDouble(sc.nextLine());
                    System.out.print("Event Type (movie/concert/sport): ");
                    String newType = sc.nextLine();
                    Event updatedEvent = createEvent(newName, newDate, newTime, newSeats,aSeats, newPrice, newVenue, newType);
                    updateEvent(updateIndex, updatedEvent);
                    break;
                case "booktickets":
                    displayEvents();
                    System.out.print("Enter event index: ");
                    int idx = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter number of tickets: ");
                    int num = Integer.parseInt(sc.nextLine());
                    bookTickets(events.get(idx), num);
                    break;
                case "canceltickets":
                    displayEvents();
                    System.out.print("Enter event index: ");
                    int idx2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter number of tickets to cancel: ");
                    int cancel = Integer.parseInt(sc.nextLine());
                    cancelTickets(events.get(idx2), cancel);
                    break;
                case "getavailableseats":
                    displayEvents();
                    break;
                case "exit":
                    System.out.println("Thank you for using the Ticket Booking System.");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void displayEvents() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println("\nEvent Index: " + i);
            displayEventDetails(events.get(i));
        }
    }
}
	

