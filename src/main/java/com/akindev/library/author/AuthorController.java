package com.akindev.library.author;

import com.akindev.library.author.models.Author;
import com.akindev.library.author.models.dtos.AuthorDto;
import com.akindev.library.author.service.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Optional<Author> author = authorService.getAuthorById(id);

        if(author.isEmpty()){
            HashMap<String, String> json = new HashMap<>();
            json.put("message","Author not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        return new ResponseEntity<>(author.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity registerAuthor(@Valid @RequestBody AuthorDto authorDto){

        Author author = new Author(authorDto.getName());

        return new ResponseEntity<>(authorService.create(author), HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody AuthorDto authorDto ){
        Optional<Author> author = authorService.updateAuthorById(id, new Author(authorDto.getName()));
        if(author.isEmpty()){
            HashMap<String, String> json = new HashMap<>();
            json.put("message","Author not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }

        return new ResponseEntity(author,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable int id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
