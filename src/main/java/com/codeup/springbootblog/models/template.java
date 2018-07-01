package com.codeup.springbootblog.models;

import javax.persistence.*;

@Entity
@Table(name="template")
public class template {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int day;

    @ManyToOne
    @JoinColumn
    private workSet workSet;



    public template(){};

    public template(int id, int day, workSet workSet) {
        this.id = id;
        this.day = day;
        this.workSet = workSet;
    }

    public template(int day, workSet workSet){
        this.day = day;
        this.workSet = workSet;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public com.codeup.springbootblog.models.workSet getWorkSet() {
        return workSet;
    }

    public void setWorkSet(com.codeup.springbootblog.models.workSet workSet) {
        this.workSet = workSet;
    }


}