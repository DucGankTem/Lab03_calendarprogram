package Lab03_Events;

import java.time.LocalDate;
import java.time.LocalTime;


public abstract class RepeatingEvent extends Event {
    private LocalDate firstOccurrence;
    private int repetitions;

    public RepeatingEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime, LocalTime endTime) {
        super(eventName, startTime, endTime);
        this.firstOccurrence = firstOccurrence;
        this.repetitions = repetitions;
        if (repetitions < 0) {
            throw new IllegalArgumentException("Repetitions must not be negative.");
        }
    }

    public LocalDate getFirstOccurrence() {
        return firstOccurrence;
    }

    public int getRepetitions() {
        return repetitions;
    }

    @Override
    public String toString() {
        if (repetitions == 0) {
            return super.toString() + " repeating for all";
        } else {
            return super.toString() + " repeating for " + repetitions;
        }
    }
}
