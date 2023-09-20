package com.example.MyBookShopApp.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private String price_old;
    private String price;
    //private Integer author_id;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price_old='" + price_old + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPrice_old() {
        return price_old;
    }

    public void setPrice_old(String price_old) {
        this.price_old = price_old;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public Integer getAuthor_id() {
//        return author_id;
//    }
//
//    public void setAuthor_id(Integer author_id) {
//        this.author_id = author_id;
//    }
}
