package com.david.graphqlstart.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Integer pages;
    private String rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, Integer pages, Author author, String rating) {
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }
}
