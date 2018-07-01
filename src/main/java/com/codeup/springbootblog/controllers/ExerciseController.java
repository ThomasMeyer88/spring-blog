package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Exercise;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.models.workSet;
import com.codeup.springbootblog.repositories.Exercises;
import com.codeup.springbootblog.repositories.Users;
import com.codeup.springbootblog.repositories.workSets;
import com.codeup.springbootblog.services.ExerciseService;
import com.codeup.springbootblog.services.workSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExerciseController {
    private ExerciseService exerciseService;
    private workSetService workDao;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, workSetService work){
        this.exerciseService = exerciseService;
        this.workDao = work;
    }

    @GetMapping("/exercises/{day}")
    public String exercisesIndex(@PathVariable long day, Model view){
        workSet work = new workSet(0, 0, 0, "exercise");

        view.addAttribute("exercises", exerciseService.getExercises().findAll());
        view.addAttribute("workSet", work);
        view.addAttribute("day", day);
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

    @PostMapping("/createplan/{day}")
    public String createDay(@PathVariable long day, workSet work){
        System.out.println(work.getReps());
        System.out.println(work.getExerciseName());

        Exercise exercise = exerciseService.getExercises().findByName(work.getExerciseName());
        System.out.println(exercise);
        work.setExercise(exercise);
        workDao.getWork().save(work);
        return "redirect:/exercises/" + day;

    }
}
