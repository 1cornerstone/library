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
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String emailAddress;

    @Column
    private String phoneNumber;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String state;

    @CreationTimestamp
    private Date dateCreated;

    @Column
    private List<Book> borrowedBooks;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

}


