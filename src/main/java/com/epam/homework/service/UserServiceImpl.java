package com.epam.homework.service;

import com.epam.homework.dao.TaskRepository;
import com.epam.homework.dao.UserRepository;
import com.epam.homework.entity.User;
import com.epam.homework.exception.UserNotFoundException;
import com.epam.homework.exception.UserRoleException;
import com.epam.homework.exception.WrongPassword;
import com.epam.security.SecurityService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(securityService.isAdmin(user.getUserRole().name())) {
            System.out.println("Welcome Admin!");
            return true;
        } else {
            throw  new UserRoleException("Go AWAY!");
        }
    }
}