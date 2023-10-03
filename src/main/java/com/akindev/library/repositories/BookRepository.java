package com.akindev.library.repositories;

import com.akindev.library.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> { }
