package com.example.MyBookShopApp.data.services;

import com.example.MyBookShopApp.data.repositories.TagRepository;
import com.example.MyBookShopApp.data.book.TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagEntity> getTagsList() {
        return tagRepository.findAll();
    }
}
