package com.hexaware.tbs.task4;

public class Venue {
	
	 private String venueName;
	    private String address;

	    
	  //Default constructor
	    public Venue()
	    {
	    	
	    } 

	    public Venue(String venueName, String address)
	    {
	        this.venueName = venueName;
	        this.address = address;
	    }

	    public String getVenueName()
	    {
	    	return venueName;
	    }
	    public void setVenueName(String venueName)
	    {
	    	this.venueName = venueName; 
	    }

	    public String getAddress()
	    { 
	    	return address; 
	    }
	    public void setAddress(String address) 
	    { 
	    	this.address = address; 
	    }

	    public void displayVenueDetails() {
	        System.out.println("\n--- Venue Details ---");
	        System.out.println("Venue: " + venueName);
	        System.out.println("Address: " + address);
	    }

}
