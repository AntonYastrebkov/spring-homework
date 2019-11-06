package com.epam.homework.service;

import com.epam.homework.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    void registerNewUser(User user);

    User signIn(String email, String password);

    void subscribe(String userEmail);

    void unsubscribe(String userEmail);

    boolean isSubscribed(String userEmail);

    boolean isAdmin(String  userEmail);

    void uploadFile(String userEmail, MultipartFile file);



}
