package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.SubSet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface subSets extends CrudRepository<SubSet, Long> {
    List<SubSet> findAll();
}
