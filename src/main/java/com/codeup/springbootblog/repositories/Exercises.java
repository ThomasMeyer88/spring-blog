package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Exercises extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();

    Exercise findByName(String name);




}

