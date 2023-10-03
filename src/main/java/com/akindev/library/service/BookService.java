package com.akindev.library.service;

import com.akindev.library.models.Book;
import com.akindev.library.models.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService  {

     Book createBook(Book book);
     List<Book> findAllBooks();
     Optional<Book> findBookById(int id);

     Optional<Book> updateBookById(int id, BookDto book);

     void deleteBook(int id);
}
