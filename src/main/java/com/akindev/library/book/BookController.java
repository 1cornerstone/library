package com.akindev.library.book;


import com.akindev.library.book.models.dtos.BookDto;
import com.akindev.library.book.services.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity getBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable int id){

    }

    @PostMapping("")
    public void createBook(@RequestBody BookDto book){

    }
    @PutMapping("/{authorId}/bookId/{isbn}")
    public void updateBook(@PathVariable int authorId, @PathVariable String isbn){}

    @DeleteMapping("/{authorId}/bookId/{isbn}")
    public void deleteBook(@PathVariable int  authorId, @PathVariable String isbn){}



}
