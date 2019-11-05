package com.epam.homework.dao;

import com.epam.homework.entity.User;

public interface UserRepository {

    User saveUser(User user);

    User findUserByEmail(String email);

    void subscribe(String userEmail, String promoCode);
}