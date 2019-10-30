package dao;

import entities.User;
import entities.UserRole;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
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
        User user = new User(userIdCount++, name, email, number, password, "", UserRole.ORDINARY_USER);
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

    @Override
    public void subscribe(String userEmail, String subscriptionKey) {
        userList.stream()
                .filter(u -> u.getEmail().equals(userEmail))
                .forEach(u -> u.setSubscription(subscriptionKey));
    }
}
