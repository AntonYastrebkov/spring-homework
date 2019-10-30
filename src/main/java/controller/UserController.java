package controller;

import entities.Task;
import entities.TaskPriority;
import entities.User;
import exception.UserNotFoundException;
import exception.WrongPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TaskService;
import service.UserService;

@Component
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  public void singUp(User user) {
    try {
      userService.registerNewUser(user);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("User successfully signed up!");
  }

  public User singIn(String email, String password) {
    User user = null;
    try {
      user = userService.signIn(email, password);
    } catch (UserNotFoundException | WrongPassword e) {
      System.out.println(e.getMessage());
    }
    if (user != null) {
      System.out.println("User registered:");
      System.out.println(user.toString());
    }
    return user;
  }


  public void subscribe(String userEmail) {
    userService.subscribe(userEmail);
  }
}
