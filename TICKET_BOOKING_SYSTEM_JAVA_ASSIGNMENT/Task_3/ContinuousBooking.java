package com.hexaware.tbs.task3;

import java.util.Scanner;

public class ContinuousBooking {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Ticket Booking System!");
        System.out.println("TYPE : Diamond   COSTS : 750 /- per ticket");
        System.out.println("TYPE : Gold      COSTS : 500 /- per ticket");
        System.out.println("TYPE : Silver    COSTS : 350 /- per ticket");
        System.out.println("Type 'Exit' to quit the booking system.");
        System.out.println();

        while (true) {
            System.out.print("Enter the type of ticket to be booked (or 'Exit' to quit): ");
            String ticketType = sc.next();

            // Check if user wants to exit
            if (ticketType.equalsIgnoreCase("EXIT")) {
                System.out.println("Thank you for using the Ticket Booking System!");
                break;
            }

            // Ticket cost variable
            int costPerTicket = 0;

            // Check ticket type and assign cost
            if (ticketType.equalsIgnoreCase("DIAMOND")) {
                costPerTicket = 750;
            } else if (ticketType.equalsIgnoreCase("GOLD")) {
                costPerTicket = 500;
            } else if (ticketType.equalsIgnoreCase("SILVER")) {
                costPerTicket = 350;
            } else {
                System.out.println("❌ Invalid ticket type. Please enter Diamond, Gold, or Silver.");
                continue; // Skip to the next loop iteration
            }

            // Get number of tickets
            System.out.print("Enter the number of tickets to book: ");
            int noOfTickets = sc.nextInt();

            int totalCost = costPerTicket * noOfTickets;
            System.out.println("✅ Tickets booked successfully!");
            System.out.println("Total cost for " + noOfTickets + " " + ticketType.toUpperCase() + " tickets: ₹" + totalCost);
            System.out.println("-----------------------------------\n");
        }

        sc.close();



	}

}
