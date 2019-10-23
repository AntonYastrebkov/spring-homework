package service;

import entities.User;

public interface UserService {

    void registerNewUser(String name, String email, String number, String password);

    User signIn(String email, String password);

    void subscribe(User user, String promoCode);
}
