package com.example.MyBookShopApp.Data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book>findAll(Pageable nextPage);

    Page<Book>findBooksByTitleContaining(String bookTitle, Pageable nextPage);
}
