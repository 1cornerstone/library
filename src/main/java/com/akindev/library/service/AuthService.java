package com.akindev.library.service;

import com.akindev.library.models.User;

public interface AuthService {

    User createUser(User user);
    String login(String email, String password);

    void logout(String token);
}
