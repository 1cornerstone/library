package com.akindev.library.author;

import com.akindev.library.author.models.Author;
import com.akindev.library.author.models.dtos.CreateAuthorDto;
import com.akindev.library.author.service.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("authors")

public class AuthorController {


    private  final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> getAuthors(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAuthorById(@PathVariable int id){

        System.out.println("here");
        Optional<Author> author = authorService.getAuthorById(id);

        if(author.isEmpty()){
            HashMap<String, String> json = new HashMap<>();
            json.put("message","Author not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        return new ResponseEntity<>(author.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity registerAuthor(@Valid @RequestBody CreateAuthorDto authorDto){

        System.out.println(authorDto);
        if(!authorDto.getAdminCode().equals("13443")){
            HashMap<String, String> json = new HashMap<>();
            json.put("message","Admin code not correct");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }

        Author author = new Author(authorDto.getName());

        return new ResponseEntity<>(authorService.create(author), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id){}

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id){}



}
