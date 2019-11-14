package com.epam.homework.controller;

import com.epam.homework.entity.User;
import com.epam.homework.entity.UserDto;
import com.epam.homework.exception.UserRoleException;
import com.epam.homework.service.UserService;
import com.epam.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final SecurityService securityService;
    private final UserService userService;

    @Autowired
    public UserController(SecurityService securityService, UserService userService) {
        this.securityService = securityService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    public void adminCheck(User user) {
        if(securityService.isAdmin(user.getUserRole().toString())) {
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
