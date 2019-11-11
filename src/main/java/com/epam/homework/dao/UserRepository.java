package com.epam.homework.dao;

import com.epam.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // User saveUser(User user);

    User findByEmail(String email);

    // void subscribe(String userEmail, String promoCode);
}