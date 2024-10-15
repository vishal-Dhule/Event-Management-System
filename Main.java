package Event_Management_System;

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        
        Event concert = new Event("Music Concert", "2024-11-12", "Auditorium", 2);
        Event conference = new Event("Tech Conference", "2024-12-01", "Convention Center", 3);
        manager.addEvent(concert);
        manager.addEvent(conference);

      
        Attendee john = new Attendee("John Doe", "john@example.com");
        Attendee alice = new Attendee("Alice Smith", "alice@example.com");
        Attendee bob = new Attendee("Bob Johnson", "bob@example.com");

        manager.registerAttendee(john);
        manager.registerAttendee(alice);
        manager.registerAttendee(bob);

      
        manager.bookTicket(john, concert);  
        manager.bookTicket(alice, concert); 


        manager.bookTicket(bob, concert);   

       
        manager.viewEventStats(concert);


        manager.cancelBooking(john, concert);

        
        manager.viewEventStats(concert);

       
        manager.viewAllEvents();
    }
}
