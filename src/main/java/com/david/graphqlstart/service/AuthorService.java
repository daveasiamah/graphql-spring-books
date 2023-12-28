package com.david.graphqlstart.service;

import com.david.graphqlstart.model.Author;
import com.david.graphqlstart.model.AuthorInput;
import com.david.graphqlstart.repository.AuthorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    public final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author createOneAuthor(@Argument AuthorInput authorInput) {
        String firstName = authorInput.firstName();
        String lastName = authorInput.lastName();

        Author newAuthor = new Author();
        newAuthor.setFirstName(firstName);
        newAuthor.setLastName(lastName);

        return authorRepository.save(newAuthor);
    }


    public Author findOneAuthor(@Argument Integer id){
        return authorRepository.findById(id).orElse(null);
    }
}
