package tdd;

import DataLayer.Model.User;
import DataLayer.Repo.UserRepoImpl;
import DataLayer.Repo.UserRepoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepoImplTest {
    private UserRepoInterface userRepo;
    private User user;


    @BeforeEach
    public void setup(){
        userRepo = new UserRepoImpl();
        user = new User();
        user.setFullName("mercy");
        user.setEmail("mercy@gmail.com");
        user.setDateOfLastPeriod("2023-03-24");
        user.setLengthOfCycle(26);
        user.setLengthOfPeriod(4);
    }


    @Test
    public void saveOneUser_countIsOneTest(){
        userRepo.save(user);
        assertEquals(1, userRepo.count());
    }

    @Test public void saveOneUser_idOfUserIsOneTest(){
        User savedUsers = userRepo.save(user);
        assertEquals(1, savedUsers.getId());
    }

    @DisplayName("Update Users Test")
    @Test public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUsers = userRepo.save(user);
        assertEquals(1, userRepo.count());
        savedUsers.setId(1);
        userRepo.save(savedUsers);
        assertEquals(1, userRepo.count());
    }

    @Test public void saveOneUser_findUserByIdTest(){
        User savedUsers = userRepo.save(user);
        assertEquals(1, savedUsers.getId());
        User foundUsers = userRepo.findById(1);
        assertEquals(foundUsers, savedUsers);
    }

    @Test public void savaOneUser_deleteOneUser_countIsZeroTest(){
        User savedUsers = userRepo.save(user);
        assertEquals(1, savedUsers.getId());
        userRepo.deleteUser(1);
        assertEquals(0, userRepo.count());
    }
}