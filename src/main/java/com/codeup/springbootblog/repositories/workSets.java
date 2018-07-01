package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.workSet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface workSets extends CrudRepository <workSet, Long> {
    List<workSet> findAll();

    workSet findById(long id);


}
