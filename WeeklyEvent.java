package Lab03_Events;

import java.time.LocalDate;
import java.time.LocalTime;


public class WeeklyEvent extends RepeatingEvent {

    public WeeklyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime, LocalTime endTime) {
        super(eventName, firstOccurrence, repetitions, startTime, endTime);
    }

    @Override
    public boolean isOnDay(LocalDate when) {
        if (repetitions == 0) {
            return when.isAfter(getFirstOccurrence().minusDays(1)) && when.getDayOfWeek() == getFirstOccurrence().getDayOfWeek();
        } else {
            LocalDate lastOccurrence = getFirstOccurrence().plusWeeks(repetitions - 1);
            return when.isAfter(getFirstOccurrence().minusDays(1)) && when.isBefore(lastOccurrence.plusWeeks(1))
                    && when.getDayOfWeek() == getFirstOccurrence().getDayOfWeek();
        }
    }

    @Override
    public String toString() {
        if (getRepetitions() == 0) {
            return super.toString() + " weeks starting on " + getFirstOccurrence();
        } else {
            return super.toString() + " weeks starting on " + getFirstOccurrence() + " for " + getRepetitions() + " weeks";
        }
    }
}
