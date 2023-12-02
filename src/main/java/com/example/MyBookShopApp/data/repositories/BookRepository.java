package com.example.MyBookShopApp.data.repositories;

import com.example.MyBookShopApp.data.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book>findAll(Pageable nextPage);

    Page<Book>findBooksByTitleContaining(String bookTitle, Pageable nextPage);

    @Query(value = "SELECT * FROM books WHERE pub_date BETWEEN :from AND :to ORDER BY pub_date DESC", nativeQuery = true)
    Page<Book>findBooksByPub_dateBetweenOrderByPub_dateDesc(@Param("from") Date from, @Param("to") Date to, Pageable nextPage);

    List<Book>findBooksByAuthorId(Integer authorId);

    @Query(value = "SELECT * FROM books WHERE genre_id = :genre_id", nativeQuery = true)
    Page<Book>findBooksByGenre_id(Pageable nextPage,@Param("genre_id") Integer genre_id);

    @Query(value = "SELECT * FROM books ORDER BY pub_date DESC", nativeQuery = true)
    Page<Book>findAllBooks(Pageable nextPage);

    Book findBookBySlug(String slug);

    List<Book> findBooksByTitleContaining(String title);
}
