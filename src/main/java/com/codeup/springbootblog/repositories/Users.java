package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public interface Users extends CrudRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAll();

    User findById(long id);

    User findByUsername(String username);
}