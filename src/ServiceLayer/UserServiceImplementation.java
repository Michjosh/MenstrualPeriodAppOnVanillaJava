package ServiceLayer;

import DTOs.CreateUserRequest;
import DTOs.FindUserResponse;
import DataLayer.Model.User;
import DataLayer.Repo.UserRepoImpl;
import DataLayer.Repo.UserRepoInterface;
import Utils.Mapper;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UserServiceImplementation implements UserServiceInterface{
        private UserRepoInterface userRepo = new UserRepoImpl();

        @Override
        public User createAccount(CreateUserRequest createUserRequest) {
            if (userExist(createUserRequest.getId())){
                throw new IllegalArgumentException(createUserRequest.getId() + " already exists");
            } else if (userFullNameExist(createUserRequest.getFullName())) {
                throw new IllegalArgumentException(createUserRequest.getFullName() + " already exists");
            }
            isEmailValid(createUserRequest);
            return userRepo.save(Mapper.toModel(createUserRequest));
        }

        private boolean userExist(int id) {
            Optional<User> foundUser = Optional.ofNullable(userRepo.findById(id));
            return foundUser.isPresent();
        }

    private boolean userFullNameExist(String name) {
        Optional<User> foundUser = Optional.ofNullable(userRepo.findByName(name));
        return foundUser.isPresent();
    }

        @Override
        public void login(int id) {
            try {
                userRepo.findById(id);
            } catch (NoSuchElementException e) {
                System.err.println("User with username does not exist.");
            }
        }

        @Override
        public void deleteAccount(int id) {
            userRepo.deleteUser(id);
        }
        @Override
        public User findUserById(int id) {
            //            if(foundUser.isEmpty()) throw new NullPointerException("No user found with ID : " + id);
//            FindUserResponse response = new FindUserResponse();
//            Mapper.toDTO(foundUser.get(), response);
            return userRepo.findById(id);
        }
        @Override
        public void findByUserName(String fullName) {
            Optional <User> foundUser = Optional.ofNullable(userRepo.findByName(fullName));
            if (foundUser.isEmpty() ) throw new NullPointerException("User does not exist");
            FindUserResponse response = new FindUserResponse();
            Mapper.toDTO(foundUser.get(), response);
        }

        private void isEmailValid(CreateUserRequest request) {
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            String email = request.getEmail();
            if (email.matches(emailRegex)) {
                return;
            } else {
                System.out.println("Invalid email address");
            }
        }
}
