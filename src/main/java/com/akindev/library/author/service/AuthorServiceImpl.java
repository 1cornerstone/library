package com.akindev.library.author.service;

import com.akindev.library.author.models.Author;
import com.akindev.library.author.repositories.AuthorRepository;
import com.akindev.library.author.service.interfaces.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {

    private  final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    @Override
    public Optional<Author> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> updateAuthorById(int id, Author author) {
        return authorRepository.findById(id).map(target->{
            target.setName(author.getName());
            return target;
        });
    }
}
