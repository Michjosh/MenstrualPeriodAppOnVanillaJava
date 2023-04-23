package tdd;

import DTOs.CreateUserRequest;
import ServiceLayer.MenstrualPeriodService;
import ServiceLayer.MenstrualPeriodServiceImpl;
import ServiceLayer.UserServiceImplementation;
import ServiceLayer.UserServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualServiceImplTest {
    private MenstrualPeriodService service;
    UserServiceInterface userServiceInterface = new UserServiceImplementation();
    private CreateUserRequest request;

    @BeforeEach
    public void setUp() {
        service = new MenstrualPeriodServiceImpl();
        request = new CreateUserRequest();
        request.setFullName("mercy");
        request.setEmail("mercy@gmail.com");
        request.setDateOfLastPeriod("2023-03-24");
        request.setLengthOfCycle(26);
        request.setLengthOfPeriod(4);
    }

    @Test
    void calculateNextMenstrualPeriodTest() {
        userServiceInterface.createAccount(request);
        String expected = service.calculateNextPeriodDate(request, request, request);
        System.out.println(service.calculateNextPeriodDate(request, request, request));
        assertEquals(expected, service.calculateNextPeriodDate(request, request, request));

    }

    @Test
    void getEstimatedPeriodDatesTest() {
        userServiceInterface.createAccount(request);
        String expected = Arrays.toString(service.getEstimatedPeriodDates(request, request, request));
        System.out.println(Arrays.toString(service.getEstimatedPeriodDates(request, request, request)));
        String result = Arrays.toString(service.getEstimatedPeriodDates(request, request, request));
        assertEquals(expected, result);
    }
}
