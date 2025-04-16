package com.hexaware.tbs.entity;

public class Booking {
    private int id;
    private Customer customer;
    private Event event;

    public Booking(int id, Customer customer, Event event) {
        this.id = id;
        this.customer = customer;
        this.event = event;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Event getEvent() { return event; }
}
