package com.akindev.library.author.models;

import com.akindev.library.book.Book;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    @Column
    private String name;

    @OneToMany(targetEntity = Book.class)
    private Book book;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    public Author(String name) {
        this.name = name;
    }

}
