package com.akindev.library.book;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {


    @GetMapping("")
    public void getBooks(){}

    @GetMapping("/{id}")
    public void getBookById(@PathVariable int id){}


    @PostMapping("")
    public void createBook(){}

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id){}

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){}



}
