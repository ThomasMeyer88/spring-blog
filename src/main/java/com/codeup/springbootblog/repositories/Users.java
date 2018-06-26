package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface Users extends CrudRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAll();

    User findById(long id);

    User findByUsername(String username);
}