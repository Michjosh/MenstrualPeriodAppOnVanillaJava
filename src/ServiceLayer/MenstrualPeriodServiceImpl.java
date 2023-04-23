package ServiceLayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MenstrualPeriodServiceImpl implements MenstrualPeriodService {

    @Override
    public String calculateNextPeriodDate(String lastPeriodDate, int cycleLength, int periodLength) {
        LocalDate date = LocalDate.parse(lastPeriodDate);
        date = date.plusDays(cycleLength - periodLength);
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String[] getEstimatedPeriodDates(String nextPeriodDate, int cycleLength, int periodLength) {
        LocalDate date = LocalDate.parse(nextPeriodDate);

        List<String> estimatedPeriodDates = new ArrayList<>();

        // Calculate the estimated period dates for the next year
        for (int i = 0; i < 6; i++) {
            date = date.plusDays(cycleLength);
            estimatedPeriodDates.add(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        return estimatedPeriodDates.toArray(new String[0]);
    }
}
