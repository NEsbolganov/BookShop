package com.example.MyBookShopApp.Data.Services;

import com.example.MyBookShopApp.Data.Repositories.TagRepository;
import com.example.MyBookShopApp.Data.book.TagEntity;
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
