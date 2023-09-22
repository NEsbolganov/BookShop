package com.example.MyBookShopApp.Data.book.file;

import jakarta.persistence.*;

@Entity
@Table(name = "book_file")
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hash;
    private String type_id;
    private String path;

    @Override
    public String toString() {
        return "BookFile{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", type_id='" + type_id + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
