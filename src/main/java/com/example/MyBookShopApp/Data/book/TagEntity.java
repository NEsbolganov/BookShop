package com.example.MyBookShopApp.Data.book;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tag_name", columnDefinition = "TEXT")
    private String tagName;

    @Column(name = "slug")
    private String slug;

    @Override
    public String toString() {
        return "TagEntity{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }

    public TagEntity() {
    }

    public TagEntity(Integer id, String tagName, String slug) {
        this.id = id;
        this.tagName = tagName;
        this.slug = slug;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
