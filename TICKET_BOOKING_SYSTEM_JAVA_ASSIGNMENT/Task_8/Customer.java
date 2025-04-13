package com.hexaware.tbs.task8;

public class Customer {
    
      
    private int customerId;
    private String name;
    private String contactInfo;

    // Constructor to initialize Customer object
    public Customer(int customerId,String name, String contactInfo) {
        this.customerId = customerId;  // Generate unique customer ID
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
