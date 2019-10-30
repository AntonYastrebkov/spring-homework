package service;

import entities.User;

public interface UserService {

    void registerNewUser(User user);

    User signIn(String email, String password);

    void subscribe(String userEmail);
}
