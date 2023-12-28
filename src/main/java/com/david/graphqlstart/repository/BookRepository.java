package com.david.graphqlstart.repository;

import com.david.graphqlstart.model.Book;
import com.david.graphqlstart.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
