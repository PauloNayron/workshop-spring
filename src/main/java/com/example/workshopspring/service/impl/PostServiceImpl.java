package com.example.workshopspring.service.impl;

import com.example.workshopspring.domain.Post;
import com.example.workshopspring.repository.PostRepository;
import com.example.workshopspring.service.PostService;
import com.example.workshopspring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository repo;

    @Override
    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public Collection<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    @Override
    public Collection<Post> fullSearch(String text, LocalDate min, LocalDate max) {
        return repo.fullSearch(text, min, max);
    }
}
