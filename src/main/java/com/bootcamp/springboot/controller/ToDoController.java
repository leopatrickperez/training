package com.bootcamp.springboot.controller;


import com.bootcamp.springboot.config.config;
import com.bootcamp.springboot.model.ToDo;
import com.bootcamp.springboot.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Controller
@RequestMapping("todo")

public class ToDoController {
    private config db;
    private ToDoService todoService;

    @Autowired
    public ToDoController(config db, ToDoService todoService) {
        this.db = db;
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDo>> getTodo() {
        List<ToDo> toDoList = this.todoService.getToDo();

        System.out.println(this.db.getDbName());

        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

}

