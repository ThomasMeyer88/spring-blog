package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAll();
    Post findOne(Long aLong);
    void delete(Post post);
    <S extends Post> S save(S s);
}