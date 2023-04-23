package PresentationLayer;

import DTOs.CreateUserRequest;
import DTOs.FindUserResponse;
import ServiceLayer.MenstrualPeriodService;
import ServiceLayer.MenstrualPeriodServiceImpl;
import ServiceLayer.UserServiceImplementation;
import ServiceLayer.UserServiceInterface;

import java.util.Arrays;

public class MPController {

    private final MenstrualPeriodService menstrualPeriodService = new MenstrualPeriodServiceImpl();

    public String calculateNextPeriodDate(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength) {
        try {
            return menstrualPeriodService.calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }


    public String getEstimatedPeriodDates(CreateUserRequest lastPeriodDate, CreateUserRequest cycleLength, CreateUserRequest periodLength){
        try {
            return Arrays.toString(menstrualPeriodService.getEstimatedPeriodDates(lastPeriodDate, cycleLength, periodLength));
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}
