package ServiceLayer;

import DTOs.CreateUserRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MenstrualPeriodServiceImpl implements MenstrualPeriodService {

    @Override
    public String calculateNextPeriodDate(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength) {
        LocalDate date = LocalDate.parse(lastPeriodDate.getDateOfLastPeriod());
        date = date.plusDays(cycleLength.getLengthOfCycle() - periodLength.getLengthOfPeriod());
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String calculateNextPeriodDate(String lastPeriodDate, int cycleLength, int periodLength) {
        LocalDate date = LocalDate.parse(lastPeriodDate);
        date = date.plusDays(cycleLength - periodLength);
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String[] getEstimatedPeriodDates(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength) {
        String nextPeriodDate = calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
        LocalDate date = LocalDate.parse(nextPeriodDate);

        List<String> estimatedPeriodDates = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            date = date.plusDays(cycleLength.getLengthOfCycle());
            estimatedPeriodDates.add(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        return estimatedPeriodDates.toArray(new String[0]);
    }
    public String[] getEstimatedPeriodDates(String lastPeriodDate, int cycleLength, int periodLength) {
        String nextPeriodDate = calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
        LocalDate date = LocalDate.parse(nextPeriodDate);

        List<String> estimatedPeriodDates = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            date = date.plusDays(cycleLength);
            estimatedPeriodDates.add(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        return estimatedPeriodDates.toArray(new String[0]);
    }
}
