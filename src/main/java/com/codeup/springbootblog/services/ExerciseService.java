package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.repositories.Exercises;
import com.codeup.springbootblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {
    private Exercises exercises;

    public ExerciseService(){};

    @Autowired
    public ExerciseService(Exercises exercises) {this.exercises = exercises;}

    public Exercises getExercises() {
        return exercises;
    }

    public void setExercises(Exercises exercises) {
        this.exercises = exercises;
    }
}
