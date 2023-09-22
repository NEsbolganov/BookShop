package com.example.MyBookShopApp.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorsService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().collect(Collectors.groupingBy((Author a) -> {return a.getLast_name().substring(0,1);}));
    }
}
