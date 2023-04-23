package DataLayer.Repo;

import DTOs.CreateUserRequest;
import DTOs.FindUserResponse;
import DataLayer.Model.User;

import java.util.List;

public interface UserRepoInterface {
    User save(User user);
    User findById(int id);
    long count();
    List<User> findAll();
    void deleteUser (int id);
    User findByName(String fullName);
}
