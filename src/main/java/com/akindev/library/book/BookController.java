package com.akindev.library.book;


import com.akindev.library.author.models.Author;
import com.akindev.library.author.service.AuthorServiceImpl;
import com.akindev.library.book.models.Book;
import com.akindev.library.book.models.dtos.BookDto;
import com.akindev.library.book.services.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@Validated
@RestController
@RequestMapping("books")
public class BookController {

    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;

    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity getBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  getBookById(@PathVariable int id){

        Optional<Book> book = bookService.findBookById(id);

        if(book.isEmpty()){
            HashMap<String, String> json = new HashMap<>();
            json.put("message","Book not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }
        return new ResponseEntity(book.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity  createBook(@Valid @RequestBody BookDto book){

        Book _book = new Book();
        _book.setTitle(book.getTitle());
        _book.setIsbnNumber(book.getIsbnNumber());
        _book.setPrice(book.getPrice());
        _book.setNumberOfPage(book.getPages());
        _book.setDateWritten(book.getDateWritten());
         Optional<Author> author = authorService.getAuthorById(book.getAuthorId());

         if(author.isEmpty()){
             HashMap<String, String> json = new HashMap<>();
             json.put("message","Author not found");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
         }

        _book.setAuthor(author.get());

        return new ResponseEntity(bookService.createBook(_book), HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity updateBook( @PathVariable int bookId, @Valid @RequestBody BookDto book){
        Optional<Book> _book = bookService.updateBookById(bookId, book);

        if(_book.isEmpty()){
            HashMap<String, String> json = new HashMap<>();
            json.put("message","Book not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }

        return new ResponseEntity(_book.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookId}", method = DELETE)
    public ResponseEntity deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity(HttpStatus.OK);
    }



}
