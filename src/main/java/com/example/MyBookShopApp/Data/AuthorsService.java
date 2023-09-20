package com.example.MyBookShopApp.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum)->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirst_name(rs.getString("first_name"));
            author.setLast_name(rs.getString("last_name"));
            return author;
        });
        return authors.stream().collect(Collectors.groupingBy((Author a) -> {return a.getLast_name().substring(0,1);}));
    }
}
