package com.example.MyBookShopApp.Data.Repositories;

import com.example.MyBookShopApp.Data.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book>findAll(Pageable nextPage);

    Page<Book>findBooksByTitleContaining(String bookTitle, Pageable nextPage);

    @Query(value = "SELECT * FROM books WHERE pub_date BETWEEN :from AND :to ORDER BY pub_date DESC", nativeQuery = true)
    Page<Book>findBooksByPub_dateBetweenOrderByPub_dateDesc(@Param("from") Date from, @Param("to") Date to, Pageable nextPage);
}
