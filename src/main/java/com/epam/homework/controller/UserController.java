package com.epam.homework.controller;

import com.epam.homework.entity.User;
import com.epam.homework.entity.UserDto;
import com.epam.homework.entity.UserRole;
import com.epam.homework.exception.UserRoleException;
import com.epam.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public void adminCheck(User user) {
        if(user.getUserRole().equals(UserRole.ADMIN_USER)) {
            System.out.println("Welcome Admin!");
        } else {
            throw  new UserRoleException("Go AWAY!");
        }

    }

    @PostMapping("/sign-up")
    public User singUp(UserDto userDto) {
        return userService.registerNewUser(userDto);
    }

    @PostMapping("/sign-in")
    public User singIn(UserDto userDto) {
        User user = userService.signIn(userDto);
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

//  @PostMapping("/unsubscribe")
//  public void unsubscribe(String userEmail) {
//    userService.unsubscribe(userEmail);
//  }
//
//
//  @PostMapping("/uploadFile")
//  public void uploadFile(
//      @RequestParam("file") MultipartFile multipartFile,
//      String email
//  ) {
//    userService.uploadFile(email, multipartFile);
//  }
}
