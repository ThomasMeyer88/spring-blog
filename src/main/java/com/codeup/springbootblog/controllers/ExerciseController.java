package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Exercise;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.models.template;
import com.codeup.springbootblog.models.workSet;
import com.codeup.springbootblog.repositories.Exercises;
import com.codeup.springbootblog.repositories.Users;
import com.codeup.springbootblog.repositories.workSets;
import com.codeup.springbootblog.services.ExerciseService;
import com.codeup.springbootblog.services.templateService;
import com.codeup.springbootblog.services.workSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ExerciseController {
    private ExerciseService exerciseService;
    private workSetService workDao;
    private templateService tempDao;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, workSetService work, templateService tempDao){
        this.exerciseService = exerciseService;
        this.workDao = work;
        this.tempDao = tempDao;
    }

    @GetMapping("/exercises/{day}")
    public String exercisesIndex(@PathVariable long day, Model view){
        workSet work = new workSet(0, 0, 0, "exercise");
        List<template> templates = tempDao.getTemplates().findAllByDay((int)day);
        List<workSet> workSets = new ArrayList();
        for(template temp: templates){
            workSet workSet = temp.getWorkSet();
            workSets.add(workSet);
        }
        view.addAttribute("workSets", workSets);
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

        template temp = new template((int) day, work);
        tempDao.getTemplates().save(temp);

        return "redirect:/exercises/" + day;
    }

    @RequestMapping(value = "/editplan/{day}", method = RequestMethod.POST)
    public String getTest(@PathVariable long day, @RequestParam int id, @RequestParam int weight, @RequestParam int reps,
                          @RequestParam int sets) {

        System.out.println("id: " + id + weight + reps + sets);
        workSet work = workDao.getWork().findById(id);
        work.setWeight(weight); work.setReps(reps); work.setSets(sets);
        workDao.getWork().save(work);
        return "redirect:/exercises/" + day;
    }

    @RequestMapping(value = "/deleteitem/{day}", method = RequestMethod.POST)
    public String deleteSet(@PathVariable long day, @RequestParam int id){
        tempDao.getTemplates().delete(tempDao.getTemplates().findByWorkSet_Id(id));
        workDao.getWork().delete(workDao.getWork().findById(id));
        return "redirect:/exercises/" + day;
    }

    @RequestMapping(value = "/duplicateitem/{day}", method = RequestMethod.POST)
    public String duplicateSet(@PathVariable long day, @RequestParam int id){
        workSet work = new workSet(workDao.getWork().findById(id));
        workDao.getWork().save(work);
        template temp = new template((int)day, work);
        tempDao.getTemplates().save(temp);
        return "redirect:/exercises/" + day;
    }
}
