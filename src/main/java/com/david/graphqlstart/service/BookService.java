package com.david.graphqlstart.service;

import com.david.graphqlstart.model.Book;
import com.david.graphqlstart.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(Book newBook){
        return bookRepository.save(newBook);
    }

    public Book findOneBook(Integer id){
      return bookRepository.findById(id).stream().filter(book ->book.getId().equals(id)).findFirst().orElse(null);
    }
}
