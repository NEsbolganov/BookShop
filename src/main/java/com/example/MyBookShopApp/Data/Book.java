package com.example.MyBookShopApp.Data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date pub_date;
    private Boolean is_bestseller;
    private String slug;
    private String title;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private Integer discount;
    private Integer price;
    //private Integer author_id;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", pub_date=" + pub_date +
                ", is_bestseller=" + is_bestseller +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", dicsount=" + discount +
                ", price=" + price +
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

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public Boolean getIs_bestseller() {
        return is_bestseller;
    }

    public void setIs_bestseller(Boolean is_bestseller) {
        this.is_bestseller = is_bestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer dicsount) {
        this.discount = dicsount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
