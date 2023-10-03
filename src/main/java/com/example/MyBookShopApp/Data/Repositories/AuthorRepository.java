package com.example.MyBookShopApp.Data.Repositories;

import com.example.MyBookShopApp.Data.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findAuthorBySlug(String slug);

    @Query(value = "SELECT id FROM authors WHERE slug = :slug",nativeQuery = true)
    Integer findIdBySlug(@Param("slug")String slug);
}
