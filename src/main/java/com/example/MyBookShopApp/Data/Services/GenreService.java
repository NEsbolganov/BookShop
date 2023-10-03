package com.example.MyBookShopApp.Data.Services;

import com.example.MyBookShopApp.Data.Repositories.GenreRepository;
import com.example.MyBookShopApp.Data.genre.GenreEntity;
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
