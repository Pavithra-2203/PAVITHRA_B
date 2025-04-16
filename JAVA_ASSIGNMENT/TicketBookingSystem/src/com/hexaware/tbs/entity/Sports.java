package com.hexaware.tbs.entity;

public class Sports extends Event {
    private String team;

    public Sports(int id, String name, String date, String venue, double price, String team) {
        super(id, name, "sports", date, venue, price); // Pass "sports" as the type
        this.team = team;
    }

    @Override
    public String getType() {
        return "Sports";
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Sports{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", date='" + getDate() + '\'' +
                ", venue='" + getVenue() + '\'' +
                ", price=" + getPrice() +
                ", team='" + team + '\'' +
                '}';
    }
}