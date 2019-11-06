package com.epam.homework.service;

import com.epam.homework.dao.TaskRepository;
import com.epam.homework.dao.UserRepository;
import com.epam.homework.entity.User;
import com.epam.homework.exception.FileUploadException;
import com.epam.homework.exception.UserNotFoundException;
import com.epam.homework.exception.UserRoleException;
import com.epam.homework.exception.WrongPassword;
import com.epam.security.SecurityService;
import io.swagger.annotations.ApiParam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final TaskRepository taskRepository;
  private final SecurityService securityService;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository,
      SecurityService securityService) {
    this.userRepository = userRepository;
    this.taskRepository = taskRepository;
    this.securityService = securityService;
  }

  @Override
  public void registerNewUser(User user) {
    if (userRepository.saveUser(user) == null) {
      throw new RuntimeException("DAO exception");
    }
  }

  @Override
  public User signIn(String email, String password) {
    User user = userRepository.findUserByEmail(email);
    if (user == null) {
      throw new UserNotFoundException("Wrong email");
    }
    if (!user.getPassword().equals(password)) {
      throw new WrongPassword("Wrong password");
    }
    return user;
  }

  @Override
  public void subscribe(String userEmail) {
    User user = userRepository.findUserByEmail(userEmail);
    String keyWord = "secret";
    String subscriptionKey = DigestUtils.md5Hex(keyWord);
    if (user.getSubscription().equals(subscriptionKey)) {
      System.out.println("Subscription already exists!");
      return;
    }
    userRepository.subscribe(userEmail, subscriptionKey);
  }

  @Override
  public void unsubscribe(String userEmail) {
    User user = userRepository.findUserByEmail(userEmail);
    userRepository.subscribe(userEmail, "NOT_SUBSCRIBED");
  }

  @Override
  public boolean isSubscribed(String userEmail) {
    User user = userRepository.findUserByEmail(userEmail);
    String keyWord = "secret";
    String subscriptionKey = DigestUtils.md5Hex(keyWord);
    if (user.getSubscription().equals(subscriptionKey)) {
      System.out.println("User is subscribed");
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isAdmin(String userEmail) {
    User user = userRepository.findUserByEmail(userEmail);
    if (securityService.isAdmin(user.getUserRole().name())) {
      System.out.println("Welcome Admin!");
      return true;
    } else {
      throw new UserRoleException("Go AWAY!");
    }
  }

  @Override
  public void uploadFile(String userEmail, MultipartFile multipartFile) {
    if (isSubscribed(userEmail)) {
      System.out.println(multipartFile);
      String fileName = multipartFile.getOriginalFilename();
      System.out.println(fileName);
      File file = new File("src/main/resources" + fileName);
      try {
        FileWriter writer = new FileWriter(file);
        writer.write(multipartFile.getInputStream().toString());
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new FileUploadException("You are not subscribed, you can not upload file! GO AWAY!");
    }
  }
}