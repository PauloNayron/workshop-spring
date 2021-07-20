package com.example.workshopspring.service;

import com.example.workshopspring.domain.Post;

import java.time.LocalDate;
import java.util.Collection;

public interface PostService {
    Post findById(String id);

    Collection<Post> findByTitle(String text);

    Collection<Post> fullSearch(String text, LocalDate min, LocalDate max);
}
