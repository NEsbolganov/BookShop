package com.example.MyBookShopApp.Data.Repositories;

import com.example.MyBookShopApp.Data.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

    List<GenreEntity>findAll();

    GenreEntity findGenreEntityBySlug(String slug);

}
