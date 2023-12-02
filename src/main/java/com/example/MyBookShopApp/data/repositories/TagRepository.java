package com.example.MyBookShopApp.data.repositories;

import com.example.MyBookShopApp.data.book.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity,Integer> {
    List<TagEntity>findAll();
}
