package Lab03_Events;

import java.time.LocalDate;
import java.time.LocalTime;


public class OneTimeEvent extends Event {
    private LocalDate date;

    public OneTimeEvent(String eventName, LocalDate date, LocalTime startTime, LocalTime endTime) {
        super(eventName, startTime, endTime);
        this.date = date;
    }

    @Override
    public boolean isOnDay(LocalDate when) {
        return date.equals(when);
    }

    @Override
    public String toString() {
        return super.toString() + " on " + date;
    }
}
