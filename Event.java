package Lab03_Events;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public abstract class Event {
    
    // Class invariants:
    // 1: startTime is before endTime

    /** The name of the event. */
    private String eventName;
    /** The time when the event starts. */
    private LocalTime startTime;
    /** The time when the event ends. */
    private LocalTime endTime;
    
    /**
     * Constructs a new event.
     * 
     * @param eventName The name of the new event.
     * @param startTime The time when the new event starts.
     * @param endTime The time when the new event ends.  This must be after startTime.
     */
    public Event(String eventName, LocalTime startTime, LocalTime endTime) {
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
    }
    
    /**
     * Gets the name of the event.
     * 
     * @return The name of the event.
     */
    public String getEventName() {
        return eventName;
    }
    
    /**
     * Gets the time when the event starts.
     * 
     * @return The time when the event starts.
     */
    public LocalTime getStartTime() {
        return startTime;
    }
    
    /**
     * Gets the time when the event ends.
     * 
     * @return The time when the event ends.
     */
    public LocalTime getEndTime() {
        return endTime;
    }
    
    /**
     * Determines whether or not the event occurs on a given day.
     * 
     * @param when The day it might occur on.
     * @return True if the event occurs on that day, or false otherwise.
     */
    public abstract boolean isOnDay(LocalDate when);
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;
        return Objects.equals(eventName, event.eventName) &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(endTime, event.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, startTime, endTime);
    }

    @Override
    public String toString() {
        return eventName + " (" + startTime + "-" + endTime + ")";
    }
}
