package com.akindev.library.book.repositories;

import com.akindev.library.book.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> { }
