package com.example.MyBookShopApp.Data.Repositories;

import com.example.MyBookShopApp.Data.book.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity,Integer> {
    List<TagEntity>findAll();
}
