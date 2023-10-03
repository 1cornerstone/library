package com.akindev.library.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    public Author(String name) {
        this.name = name;
    }
}
