package com.codeup.springbootblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="workSet")
public class workSet {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int reps;

    @Column(nullable = false)
    private int sets;

    @Column(nullable = false)
    private String exerciseName;



    @ManyToOne
    @JoinColumn
    private Exercise exercise;



    //    @ManyToOne (cascade = CascadeType.ALL)
//    @JoinColumn (name = "user_id")
//    private User user;

    public workSet (){};

    public workSet(int weight, int reps, int sets){
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;

    }

    public workSet(workSet work){
        this.exercise = work.exercise;
        this.weight = work.weight;
        this.sets = work.sets;
        this.reps = work.reps;
        this.exerciseName = work.exerciseName;
    }

    public workSet(int weight, int reps, int sets, Exercise exercise){
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
        this.exercise = exercise;
    }

    public workSet(int weight, int reps, int sets, String exerciseName){
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
        this.exerciseName = exerciseName;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
