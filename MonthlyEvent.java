package Lab03_Events;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A repeating event that occurs on the same day each month.
 * 
 * @author Chad Hogg
 */
public class MonthlyEvent extends RepeatingEvent {

    public MonthlyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime, LocalTime endTime) {
        super(eventName, firstOccurrence, repetitions, startTime, endTime);
    }

    @Override
    public boolean isOnDay(LocalDate when) {
        if (repetitions == 0) {
            return when.isAfter(getFirstOccurrence().minusDays(1));
        } else {
            LocalDate lastOccurrence = getFirstOccurrence().plusMonths(repetitions - 1);
            return when.isAfter(getFirstOccurrence().minusDays(1)) && when.isBefore(lastOccurrence.plusMonths(1));
        }
    }

    @Override
    public String toString() {
        if (getRepetitions() == 0) {
            return super.toString() + " months starting on " + getFirstOccurrence();
        } else {
            return super.toString() + " months starting on " + getFirstOccurrence() + " for " + getRepetitions() + " months";
        }
    }
}
