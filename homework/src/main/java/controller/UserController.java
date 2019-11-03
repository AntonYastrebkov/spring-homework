package controller;

import com.epam.security.SecurityService;
import entities.User;
import exception.UserNotFoundException;
import exception.UserRoleException;
import exception.WrongPassword;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  private final SecurityService securityService;
          ;

  @Autowired
  public UserController(UserService userService, SecurityService securityService) {
    this.userService = userService;
      this.securityService = securityService;
  }

  @GetMapping("/admin")
  public void adminCheck(User user) {
    if(securityService.isAdmin(user.getUserRole().name())) {
      System.out.println("Welcome Admin!");
    } else {
      throw  new UserRoleException("Go AWAY!");
    }

  }

  @PostMapping("/sign-up")
  public void singUp(User user) {
    try {
      userService.registerNewUser(user);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("User successfully signed up!");
  }

  @PostMapping("/sign-in")
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

    @PostMapping("/subscribe")
  public void subscribe(String userEmail) {
    userService.subscribe(userEmail);
  }
}
