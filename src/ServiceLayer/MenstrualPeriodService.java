package ServiceLayer;

import DTOs.CreateUserRequest;
import DTOs.FindUserResponse;

public interface MenstrualPeriodService {


    String calculateNextPeriodDate(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength);

    String[] getEstimatedPeriodDates(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength);
}
