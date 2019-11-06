package com.epam.homework.controller;

import com.epam.homework.entity.User;
import com.epam.homework.exception.UserNotFoundException;
import com.epam.homework.exception.WrongPassword;
import com.epam.homework.service.UserService;
import com.epam.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService, SecurityService securityService) {
    this.userService = userService;
  }

  @GetMapping("/admin")
  public void adminCheck(String email) {
    userService.isAdmin(email);
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

  @PostMapping("/unsubscribe")
  public void unsubscribe(String userEmail) {
    userService.unsubscribe(userEmail);
  }


  @PostMapping("/uploadFile")
  public void uploadFile(
      @RequestParam("file") MultipartFile multipartFile,
      String email
  ) {
    userService.uploadFile(email, multipartFile);
  }
}
