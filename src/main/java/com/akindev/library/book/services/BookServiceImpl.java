package com.akindev.library.book.services;

import com.akindev.library.book.models.Book;
import com.akindev.library.book.models.dtos.BookDto;
import com.akindev.library.book.repositories.BookRepository;
import com.akindev.library.book.services.interfaces.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    @Transactional
    @Override
    public Optional<Book> updateBookById(int id, BookDto book) {
        // check if authorId is the same
        return bookRepository.findById(id).map(_book ->{
            _book.setPrice(book.getPrice());
            _book.setTitle(book.getTitle());
            _book.setNumberOfPage(book.getPages());
            _book.setIsbnNumber(book.getIsbnNumber());
            return _book;
        } );
    }

    @Override
    public void deleteBook(int id) {
        Optional<Book> book = findBookById(id);
        if(book.isPresent()){
//            if(book.get().getAuthor().getId() == authorId)
                bookRepository.deleteById(id);
        }
    }

}
