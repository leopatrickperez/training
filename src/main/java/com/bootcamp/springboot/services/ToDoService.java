package com.bootcamp.springboot.services;

import com.bootcamp.springboot.config.config;
import com.bootcamp.springboot.model.ToDo;
import com.bootcamp.springboot.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return this.toDoRepository.findAll();
    }

    public Optional<ToDo> findById(long id) {
        return this.toDoRepository.findById(id);
    }

    public Optional<ToDo> findByName(String name) {
        return this.toDoRepository.findByName(name);
    }

    public void save(ToDo toDo) {
        this.toDoRepository.save(toDo);
    }

    public void delete(long id) {
        this.toDoRepository.deleteById(id);
    }
}

