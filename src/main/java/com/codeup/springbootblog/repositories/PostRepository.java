package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String Title);

    List<Post> findAll();

}