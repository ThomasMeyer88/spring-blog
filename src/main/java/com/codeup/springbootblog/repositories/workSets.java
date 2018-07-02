package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.WorkSet;
import com.codeup.springbootblog.models.template;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface workSets extends CrudRepository <WorkSet, Long> {
    List<WorkSet> findAll();

    WorkSet findById(long id);

    List<WorkSet> findAllById(long id);
    List<WorkSet> findAllByTemplate(template temp);



}
