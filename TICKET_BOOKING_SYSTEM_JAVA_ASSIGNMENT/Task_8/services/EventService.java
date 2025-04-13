package com.hexaware.tbs.task8.services;

import com.hexaware.tbs.task8.Event;
import java.util.List;

public interface EventService {
    void createEvent(Event event);
    Event getEventDetails(int eventId);
    int getAvailableNoOfTickets(int eventId);
    List<Event> getAllEvents();
}
