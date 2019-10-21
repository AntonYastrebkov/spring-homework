package dao;

import entities.Task;
import entities.User;

import java.util.List;

public interface UserRepository {

    User saveUser(String name, String email, String number, String password);

    User findUserByEmail(String email);
}
