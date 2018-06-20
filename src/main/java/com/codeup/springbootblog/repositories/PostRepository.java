package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String Title);

    List<Post> findAll();
}