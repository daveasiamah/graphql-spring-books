package com.david.graphqlstart.controller;

import com.david.graphqlstart.model.Author;
import com.david.graphqlstart.model.AuthorInput;
import com.david.graphqlstart.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {
    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    List<Author> allAuthors(){
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author findOneAuthor(@Argument Integer id){
        return authorService.findOneAuthor(id);
    }

    @MutationMapping
    public Author createOneAuthor(@Argument("author")AuthorInput authorInput){
        return authorService.createOneAuthor(authorInput);
    }
}
