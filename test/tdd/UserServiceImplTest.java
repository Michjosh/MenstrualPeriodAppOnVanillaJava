package tdd;

import DTOs.CreateUserRequest;
import DataLayer.Model.User;
import ServiceLayer.UserServiceImplementation;
import ServiceLayer.UserServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {

    private UserServiceInterface userService;
    private CreateUserRequest request;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImplementation();
        request = new CreateUserRequest();
        request.setFullName("mercy");
        request.setEmail("mercy@gmail.com");
        request.setDateOfLastPeriod("2023-03-24");
        request.setLengthOfCycle(26);
        request.setLengthOfPeriod(4);
    }

    @Test
    void test_saveNewUser_Id() {
        User savedUsers = userService.createAccount(request);
        assertTrue(savedUsers.getId() != 0);
    }

    @Test
    void test_duplicateUserNameThrowsException() {
        request.setFullName("mercy");
        request.setEmail("mercy@gmail.com");
        request.setDateOfLastPeriod("2023-03-24");
        request.setLengthOfCycle(26);
        request.setLengthOfPeriod(4);
        userService.createAccount(request);
        assertThrows(IllegalArgumentException.class, () -> userService.createAccount(request));
    }

    @Test
    public void test_findUserById() {
        userService.createAccount(request);
        System.out.println(userService.findUserById(1).toString());
        assertEquals("mercy", userService.findUserById(1).getFullName());
    }

    @Test
    public void test_throwExceptionWhenIdIsWrong() {
        request.setFullName("mercy");
        request.setEmail("mercy@gmail.com");
        request.setDateOfLastPeriod("2023-03-24");
        request.setLengthOfCycle(26);
        request.setLengthOfPeriod(4);
        request.setId(1);
        userService.createAccount(request);
        assertThrows(IllegalArgumentException.class, () -> userService.createAccount(request));

    }
}