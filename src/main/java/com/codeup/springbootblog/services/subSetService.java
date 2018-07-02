package com.codeup.springbootblog.services;


import com.codeup.springbootblog.repositories.subSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class subSetService {
    private subSets sets;

    @Autowired
    public subSetService(subSets sets){this.sets = sets;}

    public subSets getSets() {
        return sets;
    }


}


