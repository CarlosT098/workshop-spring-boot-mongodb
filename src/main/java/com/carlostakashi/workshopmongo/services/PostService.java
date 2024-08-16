package com.carlostakashi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlostakashi.workshopmongo.domain.Post;
import com.carlostakashi.workshopmongo.repository.PostRepository;
import com.carlostakashi.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {

        Optional<Post> Post = repo.findById(id);
        if (Post.isEmpty()) {
            throw new ObjectNotFoundException("objeto nao encontrado");
        }
        return Post.get();
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
