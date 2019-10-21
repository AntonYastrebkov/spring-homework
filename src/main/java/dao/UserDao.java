package dao;

import entities.Task;
import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    User user = new User(userIdCount++, name, email, number, password);
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

  //  public Long getUserById() {
//    return user.getId();
//  }
//
//  public String getName() {
//    return user.getName();
//  }
//
//  public String getPhoneNumber() {
//    return user.getPhoneNumber();
//  }
//
//  public String getEmail() {
//    return user.getEmail();
//  }
//
//  public String getPassword() {
//    return user.getPassword();
//  }
}
