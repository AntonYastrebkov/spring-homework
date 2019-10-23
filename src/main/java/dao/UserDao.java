package dao;

import entities.User;
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

    @Override
    public void subscribe(String userEmail, String promoCode) {
        User user = findUserByEmail(userEmail);
        String keyWord = "secret";
        String subscriptionKey = DigestUtils.md5Hex(keyWord);
        String promoCodeKey = DigestUtils.md5Hex(promoCode);
        if(user.getSubscription().equals(subscriptionKey)){
            System.out.println("Subscription already exists!");
            return;
        }
        if(!subscriptionKey.equals(promoCodeKey)) {
            System.out.println("Wrong promo code word, subscription denied!");
            return;
        }
        user.setSubscription(subscriptionKey);
        System.out.println("Subscription success!");
    }
}
