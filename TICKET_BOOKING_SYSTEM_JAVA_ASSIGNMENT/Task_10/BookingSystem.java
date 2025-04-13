package com.hexaware.tbs.task10;

import java.util.Set;
import java.util.TreeSet;

public class BookingSystem {

	private Set<Event> events;

    public BookingSystem() {
        this.events = new TreeSet<>((e1, e2) -> {
            int nameCompare = e1.getName().compareTo(e2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            }
            return e1.getLocation().compareTo(e2.getLocation());
        });
    }

    public void addEvent(Event event) {
        events.add(event); // TreeSet avoids duplicates and keeps sorted
    }

    public boolean removeEvent(int eventId) {
        return events.removeIf(event -> event.getId() == eventId);
    }

    public void listEvents() {
        for (Event event : events) {
            System.out.println("Event ID: " + event.getId() +
                               ", Name: " + event.getName() +
                               ", Location: " + event.getLocation());
        }
    }

    // ✅ This method fixes the error you mentioned
    public Event getEventById(int id) {
        for (Event e : events) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}