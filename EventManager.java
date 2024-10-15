package Event_Management_System;

import java.util.*;

public class EventManager {
    private List<Event> events = new ArrayList<>();
    private Set<Attendee> attendees = new HashSet<>();
    private Map<Event, Set<Attendee>> eventAttendees = new HashMap<>();
    private Map<Event, List<String>> seatAssignments = new HashMap<>();
    private Map<Event, Queue<Attendee>> waitingLists = new HashMap<>();

    public void addEvent(Event event) {
        events.add(event);
        eventAttendees.put(event, new HashSet<>());
        seatAssignments.put(event, new ArrayList<>());
        waitingLists.put(event, new LinkedList<>());
    }

  
    public void registerAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

   
    public void bookTicket(Attendee attendee, Event event) {
        if (event.getAvailableSeats() > 0) {
            event.bookSeat();
            eventAttendees.get(event).add(attendee);
            seatAssignments.get(event).add("Seat #" + (event.getTotalSeats() - event.getAvailableSeats()));
            System.out.println(attendee.getName() + " booked for " + event.getEventName());
        } else {
            System.out.println(event.getEventName() + " is fully booked. Adding " + attendee.getName() + " to the waitlist.");
            waitingLists.get(event).offer(attendee);
        }
    }

    
    public void cancelBooking(Attendee attendee, Event event) {
        if (eventAttendees.get(event).contains(attendee)) {
            eventAttendees.get(event).remove(attendee);
            event.cancelSeat();
            System.out.println(attendee.getName() + " canceled booking for " + event.getEventName());

            
            if (!waitingLists.get(event).isEmpty()) {
                Attendee nextInLine = waitingLists.get(event).poll();
                bookTicket(nextInLine, event);
            }
        } else {
            System.out.println(attendee.getName() + " does not have a booking for " + event.getEventName());
        }
    }

   
    public void viewEventStats(Event event) {
        System.out.println("Event: " + event.getEventName());
        System.out.println("Available Seats: " + event.getAvailableSeats());
        System.out.println("Attendees: " + eventAttendees.get(event));
        System.out.println("Seat Assignments: " + seatAssignments.get(event));
        System.out.println("Waitlist: " + waitingLists.get(event));
    }


    public void viewAllEvents() {
        System.out.println("Events List: " + events);
    }
}

