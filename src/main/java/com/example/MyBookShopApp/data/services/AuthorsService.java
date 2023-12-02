package com.example.MyBookShopApp.data.services;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Author getAuthorBySlug(String slug) {
        return authorRepository.findAuthorBySlug(slug);
    }

    public Integer getAuthorIdBySlug(String slug){
        return authorRepository.findIdBySlug(slug);
    }
}
