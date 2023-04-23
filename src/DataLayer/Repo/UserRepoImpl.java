package DataLayer.Repo;

import DataLayer.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepoInterface {
    private int count = 0;

    private List<User> users = new ArrayList<>();
    @Override
    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if(userHasNotBeenSaved){
            user.setId( generateId());
            users.add(user);
            count++;
        }

        return user;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public User findById(int id) {
        for(User user : users) if (user.getId() == id) return user;

        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return null;
    }


    @Override
    public void deleteUser(int id) {
        for (User user : users){
            if (user.getId() == id){
                users.remove(id-1);
                count--;
                break;
            }
        }

    }


    @Override
    public User findByName(String fullName) {
        for (User user : users){
            if (user.getFullName().equalsIgnoreCase(fullName)) return user;
        }
        return null;
    }


}