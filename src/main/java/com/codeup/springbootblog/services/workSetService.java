package com.codeup.springbootblog.services;

import com.codeup.springbootblog.repositories.workSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class workSetService {
    private workSets work;

    public workSetService(){};

    @Autowired
    public workSetService(workSets work) {this.work = work;}

    public workSets getWork() {
        return work;
    }

    public void setWork(workSets work) {
        this.work = work;
    }


}
