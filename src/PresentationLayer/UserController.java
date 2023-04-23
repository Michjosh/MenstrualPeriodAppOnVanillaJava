package PresentationLayer;

import DTOs.CreateUserRequest;
import DataLayer.Model.User;
import ServiceLayer.UserServiceImplementation;
import ServiceLayer.UserServiceInterface;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UserController {

        private static UserServiceInterface userService = new UserServiceImplementation();

        public void register(CreateUserRequest request) {
            userService.createAccount(request);
        }

        public User findUserById(int response) {
            return userService.findUserById(response);
        }

    public void login(int id) {
        try {
            userService.login(id);
        } catch (NoSuchElementException e) {
            System.err.println("User with ID: " +id+ " does not exist.");
        }
    }

    public void deleteAccount(int id){
        try {
            userService.deleteAccount(id);
        } catch (NoSuchElementException e) {
            System.err.println("User with ID: " +id+ " does not exist.");
        }
    }

}
