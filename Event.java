package Event_Management_System;

import java.util.Objects;

public class Event {
    private String eventName;
    private String eventDate;
    private String location;
    private int totalSeats;
    private int availableSeats;

    public Event(String eventName, String eventDate, String location, int totalSeats) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getEventName() { return eventName; }
    public String getEventDate() { return eventDate; }
    public String getLocation() { return location; }
    public int getAvailableSeats() { return availableSeats; }
    public int getTotalSeats() {return totalSeats;}
    
    public void bookSeat() { availableSeats--; }
    public void cancelSeat() { availableSeats++; }

    @Override
    public String toString() {
        return "Event{" + "name=" + eventName + ", date=" + eventDate + ", location=" + location + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventName.equals(event.eventName) && eventDate.equals(event.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventDate);
    }
}
