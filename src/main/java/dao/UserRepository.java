package dao;

import entities.User;

public interface UserRepository {

    User saveUser(String name, String email, String number, String password);

    User findUserByEmail(String email);
}
