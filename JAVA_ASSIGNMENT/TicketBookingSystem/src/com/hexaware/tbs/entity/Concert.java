package com.hexaware.tbs.entity;

public class Concert extends Event {
    private String performer;

    public Concert(int id, String name, String date, String venue, double price, String performer) {
        super(id, name, "concert", date, venue, price); // Pass "concert" as the type
        this.performer = performer;
    }

    @Override
    public String getType() {
        return "Concert";
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", date='" + getDate() + '\'' +
                ", venue='" + getVenue() + '\'' +
                ", price=" + getPrice() +
                ", performer='" + performer + '\'' +
                '}';
    }
}