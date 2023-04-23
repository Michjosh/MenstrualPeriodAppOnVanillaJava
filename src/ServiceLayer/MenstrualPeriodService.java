package ServiceLayer;

public interface MenstrualPeriodService {

    /**
     * Calculates the date of the next menstrual period based on the date of the last period,
     * the length of the menstrual cycle, and the length of the period.
     *
     * @param lastPeriodDate the date of the last menstrual period (in the format "YYYY-MM-DD")
     * @param cycleLength the length of the menstrual cycle (in days)
     * @param periodLength the length of the menstrual period (in days)
     * @return the date of the next menstrual period (in the format "YYYY-MM-DD")
     */
    String calculateNextPeriodDate(String lastPeriodDate, int cycleLength, int periodLength);

    /**
     * Calculates a list of estimated menstrual period dates for the next year based on the
     * date of the next menstrual period, the length of the menstrual cycle, and the length
     * of the period.
     *
     * @param nextPeriodDate the date of the next menstrual period (in the format "YYYY-MM-DD")
     * @param cycleLength the length of the menstrual cycle (in days)
     * @param periodLength the length of the menstrual period (in days)
     * @return an array of estimated menstrual period dates (in the format "YYYY-MM-DD")
     */
    String[] getEstimatedPeriodDates(String nextPeriodDate, int cycleLength, int periodLength);
}
