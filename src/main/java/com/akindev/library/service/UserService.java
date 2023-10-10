package com.akindev.library.service;

import com.akindev.library.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    Optional<User> getUserByNin(Long nin);

    void deleteUserById(String nin);

   void borrowBookById(int id);

   void returnBookById(int id);


}
