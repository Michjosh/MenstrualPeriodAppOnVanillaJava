package ServiceLayer;

import DTOs.CreateUserRequest;
import DataLayer.Model.User;

import java.util.Optional;

public interface UserServiceInterface {
        User createAccount(CreateUserRequest createUserRequest);
        void login(int id);
        void deleteAccount(int id);
        User findUserById(int id);
        void findByUserName(String username);
}
