package com.david.graphqlstart.model;

public record BookInput(String title, Integer pages, AuthorInput author, String rating) {
    public AuthorInput getAuthor(){
        return author;
    }
}
