package com.david.graphqlstart.controller;

import com.david.graphqlstart.model.*;
import com.david.graphqlstart.repository.BookRepository;
import com.david.graphqlstart.service.AuthorService;
import com.david.graphqlstart.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
    @QueryMapping
    public List<Book> allBooks(){
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book findOneBook(@Argument Integer id){
        return bookService.findOneBook(id);
    }

    @MutationMapping
    public Book createOneBook(@Argument("book") BookInput bookInput) {
        String title = bookInput.title();
        int pages = bookInput.pages();
        String rating = bookInput.rating();
        AuthorInput authorInput = bookInput.getAuthor();

        Author author = null;
        if (authorInput != null) {
            author = new Author();
            author.setFirstName(authorInput.firstName());
            author.setLastName(authorInput.lastName());
            author = authorService.createOneAuthor(authorInput);
        }

        Book newBook = new Book(title, pages, author, rating);
        return bookService.createBook(newBook);
    }

}
