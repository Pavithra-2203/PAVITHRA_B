package com.hexaware.tbs.task2;

import java.util.Scanner;

public class TicketCost {

	public static void main(String[] args) {
		
        Scanner sc=new Scanner(System.in);
		
		//Getting ticket for no of ticket and type of ticket
		
		System.out.println("TYPE : Diamond   COSTS : 750 /- per ticket");
		System.out.println("TYPE : Gold      COSTS : 500 /- per ticket");
		System.out.println("TYPE : Silver    COSTS : 350 /- per ticket");
		System.out.println();
		System.out.println("Enter the Type of ticket to be booked : ");
		
		String ticketType=sc.next();
		
		System.out.println("Enter the No of tickets to be booked : ");
		int noOfTickets=sc.nextInt();
		
	    int costPerTicket=0;
		
		// Use equalsIgnoreCase for case-insensitive comparison
        if (ticketType.equalsIgnoreCase("DIAMOND")) 
        {
            costPerTicket = 750;
        } 
        else if (ticketType.equalsIgnoreCase("GOLD"))
        {
            costPerTicket = 500;
        } 
        else if (ticketType.equalsIgnoreCase("SILVER")) 
        {
            costPerTicket = 350;
        } 
        else 
        {
            System.out.println("Please enter a valid ticket type.");
        }

        int totalCost = noOfTickets * costPerTicket;
        System.out.println("Total cost for " + noOfTickets + " " + ticketType.toUpperCase() + "  type tickets is ₹" + totalCost);

        sc.close();


	}

}
