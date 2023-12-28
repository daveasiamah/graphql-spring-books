package com.david.graphqlstart.repository;

import com.david.graphqlstart.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
