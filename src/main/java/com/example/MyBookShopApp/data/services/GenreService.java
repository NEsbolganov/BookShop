package com.example.MyBookShopApp.data.services;

import com.example.MyBookShopApp.data.repositories.GenreRepository;
import com.example.MyBookShopApp.data.genre.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreEntity>getAllGenres(){
        return genreRepository.findAll();
    }

    public GenreEntity getGenreBySlug(String slug) {
        return genreRepository.findGenreEntityBySlug(slug);
    }
}
