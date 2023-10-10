package com.akindev.library.service.implementation;

import com.akindev.library.models.User;
import com.akindev.library.repositories.BookRepository;
import com.akindev.library.repositories.UserRepository;
import com.akindev.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BookServiceImpl bookService;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserByNin(Long nin) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(String nin) {

    }

    @Override
    public void borrowBookById(int id) {

    }

    @Override
    public void returnBookById(int id) {

    }
}
