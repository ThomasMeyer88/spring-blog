package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.template;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface templates extends CrudRepository <template, Long> {
    List<template> findAll();

    List<template> findAllByDay(int day);

    template findByWorkSet_Id(long id);


}
