package Event_Management_System;

import java.util.Objects;

public class Attendee {
    private String name;
    private String email;

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Attendee{" + "name=" + name + ", email=" + email + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return email.equals(attendee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

