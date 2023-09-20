package com.example.MyBookShopApp.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book>findBooksByAuthorFirst_name(String name);
}
