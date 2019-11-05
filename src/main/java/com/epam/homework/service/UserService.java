package com.epam.homework.service;

import com.epam.homework.entity.User;

public interface UserService {

    void registerNewUser(User user);

    User signIn(String email, String password);

    void subscribe(String userEmail);

    boolean isSubscribed(User user);
}
