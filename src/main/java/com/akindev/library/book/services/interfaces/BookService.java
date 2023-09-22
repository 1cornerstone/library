package com.akindev.library.book.services.interfaces;

import com.akindev.library.book.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService  {

    public Book createBook(Book book);
    public List<Book> findAllBooks();
    public Optional<Book> findBookById(int id);

    public Optional<Book> updateBookById(int id, Book book);

    public void deleteBook(int id);
}
