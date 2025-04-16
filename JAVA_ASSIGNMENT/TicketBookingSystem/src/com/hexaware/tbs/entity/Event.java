package com.hexaware.tbs.entity;

public class Event {
    private int id;
    private String name;
    private String type;
    private String date;
    private String venue;
    private double price;

    public Event(int id, String name, String type, String date, String venue, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.venue = venue;
        this.price = price;
    }

    public Event(String name, String type, String date, String venue, double price) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.venue = venue;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getDate() { return date; }
    public String getVenue() { return venue; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
}
