package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Exercise;
import com.codeup.springbootblog.models.SubSet;
import com.codeup.springbootblog.models.WorkSet;
import com.codeup.springbootblog.models.template;
import com.codeup.springbootblog.services.ExerciseService;
import com.codeup.springbootblog.services.subSetService;
import com.codeup.springbootblog.services.templateService;
import com.codeup.springbootblog.services.workSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ExerciseController {
    private ExerciseService exerciseService;
    private workSetService workDao;
    private templateService tempDao;
    private subSetService setDao;

    @Autowired
    public ExerciseController
            (ExerciseService exerciseService, workSetService work, templateService tempDao,
             subSetService setDao){
        this.exerciseService = exerciseService;
        this.workDao = work;
        this.tempDao = tempDao;
        this.setDao = setDao;
    }

    @GetMapping("/tests")
    public String tests(Model view){
        List<WorkSet> workSets = workDao.getWork().findAll();
        for (WorkSet workSet : workSets) {
            System.out.println(workSet.getId());
            List<SubSet> subSets = workSet.getSubSets();
            for (SubSet subSet : subSets) {
                System.out.println("Subset is here" + subSet.getId());
            }
        }
        return("posts/index");
    }

    @GetMapping("/exercises/{day}")
    public String exercisesIndex(@PathVariable long day, Model view){
        List<WorkSet> daySet = workDao.getWork().findAllByTemplate(tempDao.getTemplates().findOne(1L));
        System.out.println(daySet.size());
        SubSet subSet = new SubSet(0, 0, " ", null);
        view.addAttribute("workSets", daySet);
        view.addAttribute("subSet", subSet);
        view.addAttribute("exercises", exerciseService.getExercises().findAll());
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
    public String createDay(@PathVariable long day, SubSet subSet){
        System.out.println(subSet.getExerciseName());
        WorkSet newWorkSet = new WorkSet(subSet.getExerciseName(), exerciseService.getExercises().findByName(subSet.getExerciseName()));
        workDao.getWork().save(newWorkSet);
        SubSet newSubSet = subSet;
        template temp = new template((int)day);
        tempDao.getTemplates().save(temp);
        newWorkSet.setTemplate(temp);
        newSubSet.setWorkSet(newWorkSet);
        setDao.getSets().save(newSubSet);
        return "redirect:/exercises/" + day;
    }

    @RequestMapping(value = "/editplan/{day}", method = RequestMethod.POST)
    public String getTest(@PathVariable long day, @RequestParam int id, @RequestParam int weight, @RequestParam int reps,
                          @RequestParam int sets) {


        return "redirect:/exercises/" + day;
    }

    @RequestMapping(value = "/deleteitem/{day}", method = RequestMethod.POST)
    public String deleteSet(@PathVariable long day, @RequestParam int id){
        return "redirect:/exercises/" + day;
    }

    @RequestMapping(value = "/duplicateitem/{day}", method = RequestMethod.POST)
    public String duplicateSet(@PathVariable long day, @RequestParam int id){

        return "redirect:/exercises/" + day;
    }
}
