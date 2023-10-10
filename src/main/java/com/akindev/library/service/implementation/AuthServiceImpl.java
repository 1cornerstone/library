package com.akindev.library.service.implementation;

import com.akindev.library.models.User;
import com.akindev.library.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserServiceImpl userService;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public void logout(String token) {}
}
