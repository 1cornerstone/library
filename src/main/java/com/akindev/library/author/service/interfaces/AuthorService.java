package com.akindev.library.author.service.interfaces;

import com.akindev.library.author.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author create(Author author);

    List<Author> findAll();

    Optional<Author> getAuthorById(int id);

     void deleteAuthorById(int id);

     Optional<Author> updateAuthorById(int id, Author author);
}
