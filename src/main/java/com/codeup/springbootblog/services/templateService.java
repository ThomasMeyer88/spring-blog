package com.codeup.springbootblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeup.springbootblog.repositories.templates;




@Service
public class templateService {
    private templates templates;

    public templateService(){};

    @Autowired
    public templateService(templates templates) {this.templates = templates;}

    public com.codeup.springbootblog.repositories.templates getTemplates() {
        return templates;
    }

    public void setTemplates(com.codeup.springbootblog.repositories.templates templates) {
        this.templates = templates;
    }
}
