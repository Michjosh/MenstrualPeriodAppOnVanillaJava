package ServiceLayer;

import DTOs.CreateUserRequest;

public interface MenstrualPeriodService {


    String calculateNextPeriodDate(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength);

    String calculateNextPeriodDate(String lastPeriodDate, int cycleLength, int periodLength);

    String[] getEstimatedPeriodDates(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength);

    String[] getEstimatedPeriodDates(String lastPeriodDate, int cycleLength, int periodLength);
}

