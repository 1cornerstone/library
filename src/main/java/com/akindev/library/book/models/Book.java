package com.akindev.library.book.models;

import com.akindev.library.author.models.Author;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String title;

    @Column
    private int numberOfPage;

    @Column
    private double price;

    @Column
    private String isbnNumber;

    @Column
    private Date dateWritten;

    @CreationTimestamp
    private Date dateCreated;

    @ManyToOne(targetEntity = Author.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "author_id", nullable = false, referencedColumnName = "id")
    private Author author;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;


    public Book() {}

    public Book(String title, int numberOfPage, double price, String isbnNumber, Date dateWritten) {
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.isbnNumber = isbnNumber;
        this.dateWritten = dateWritten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }
}
