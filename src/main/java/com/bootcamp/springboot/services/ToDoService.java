package com.bootcamp.springboot.services;

import com.bootcamp.springboot.model.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoService {
    public List<ToDo> getToDo() {
        List<ToDo> todo = new ArrayList<>();
        todo.add(new ToDo("Exercise1", "Complete"));
        todo.add(new ToDo("Exercise2", "On-Going"));
        return todo;
    }
}

