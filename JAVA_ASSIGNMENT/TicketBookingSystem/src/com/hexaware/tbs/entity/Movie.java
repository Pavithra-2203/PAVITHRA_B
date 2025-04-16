package com.hexaware.tbs.entity;

public class Movie extends Event {
    private String genre;
    private String director;

    // Constructor with all required parameters
    public Movie(int id, String name, String date, String venue, double price, String genre, String director) {
        super(id, name, "movie", date, venue, price); // Pass "movie" as the type
        this.genre = genre;
        this.director = director;
    }

    // Getters and Setters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", date='" + getDate() + '\'' +
                ", venue='" + getVenue() + '\'' +
                ", price=" + getPrice() +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}