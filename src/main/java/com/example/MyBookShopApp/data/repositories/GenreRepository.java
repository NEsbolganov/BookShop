package com.example.MyBookShopApp.data.repositories;

import com.example.MyBookShopApp.data.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

    List<GenreEntity>findAll();

    GenreEntity findGenreEntityBySlug(String slug);

}
