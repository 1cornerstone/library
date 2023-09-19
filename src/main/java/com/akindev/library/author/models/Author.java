package com.akindev.library.author.models;

import com.akindev.library.book.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    @Column
    private String name;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    public Author(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
