package dao;

import entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserRepository {
    private final List<User> userList;

    private long userIdCount;

    public UserDao() {
        this.userList = new ArrayList<>();
        this.userIdCount = 1;
    }


    @Override
    public User saveUser(String name, String email, String number, String password) {
        User user = new User(userIdCount++, name, email, number, password, "");
        userList.add(user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }


}
