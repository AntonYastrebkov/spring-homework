package dao;

import entities.User;

public interface UserRepository {

    User saveUser(User user);

    User findUserByEmail(String email);

    void subscribe(String userEmail, String promoCode);
}

