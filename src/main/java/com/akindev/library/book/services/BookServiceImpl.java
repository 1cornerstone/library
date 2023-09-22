package com.akindev.library.book.services;

import com.akindev.library.book.models.Book;
import com.akindev.library.book.repositories.BookRepository;
import com.akindev.library.book.services.interfaces.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return  bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Optional<Book> findBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> updateBookById(int id, Book book) {
        return bookRepository.findById(id).map(_book ->{
            _book.setPrice(book.getPrice());
            _book.setTitle(book.getTitle());
            _book.setNumberOfPage(book.getNumberOfPage());
            _book.setIsbnNumber(book.getIsbnNumber());
            return  _book;
        } );
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
