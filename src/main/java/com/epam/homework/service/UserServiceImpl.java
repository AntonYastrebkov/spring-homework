package com.epam.homework.service;

import com.epam.homework.dao.TaskRepository;
import com.epam.homework.dao.UserRepository;
import com.epam.homework.entity.User;
import com.epam.homework.exception.UserNotFoundException;
import com.epam.homework.exception.WrongPassword;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final String KEYWORD = "secret";
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
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
        String subscriptionKey = DigestUtils.md5Hex(KEYWORD);
        if (user.getSubscription().equals(subscriptionKey)) {
            System.out.println("Subscription already exists!");
            return;
        }

        userRepository.subscribe(userEmail, subscriptionKey);
    }

    @Override
    public boolean isSubscribed(User user) {
        return DigestUtils.md5Hex(KEYWORD).equals(user.getSubscription());
    }
}