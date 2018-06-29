package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Exercise;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.repositories.Exercises;
import com.codeup.springbootblog.repositories.Users;
import com.codeup.springbootblog.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExerciseController {
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
    public String exercisesIndex(Model view){
        Exercise exercise = new Exercise("Squat", "Legs");
        view.addAttribute("exercises", exerciseService.getExercises().findAll());
        return("posts/exercises");
    }

    @GetMapping("/newexercise")
    public String create(Model view){
        Exercise exercise = new Exercise(" ", " ");
        view.addAttribute("exercise", exercise);
        return("posts/newExercise");

    }

    @PostMapping("/newexercise")
    public String createExercise(Exercise exercise){
        System.out.println(exercise);
        exerciseService.getExercises().save(exercise);
        return "redirect:/exercises";
    }


}
