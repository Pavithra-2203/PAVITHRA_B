package com.hexaware.tbs.task1;

import java.util.Scanner;

public class TicketsBooking {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int availableTickets=0;
		int ticketsToBeBooked=0;
		
		// Getting available ticket as input
		System.out.println("Enter the total no of available tickets : ");
		availableTickets=sc.nextInt();
		
		//Getting no of tickets to be booked as input
		System.out.println("Enter the no of tickets to be booked : ");
		ticketsToBeBooked=sc.nextInt();
		
		
		// Using conditional statements (if-else) to determine whether the ticket is available or not. 
		if(availableTickets>=ticketsToBeBooked) 
		{
			System.out.println("Your Tickets has been booked successfully");
			int remainingTickets=availableTickets-ticketsToBeBooked;
			System.out.println("Remaining no of tickets : "+remainingTickets);
		}
		else
		{
			System.out.println("Sorry to inform!!! Only "+availableTickets+" tickets is available. So unable to book your tickets");
		}
		sc.close();



	}

}
