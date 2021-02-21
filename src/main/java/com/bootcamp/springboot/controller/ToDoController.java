package com.bootcamp.springboot.controller;


import com.bootcamp.springboot.config.config;
import com.bootcamp.springboot.model.ToDo;
import com.bootcamp.springboot.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/todo")
public class ToDoController {


    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<ToDo> toDos = new ArrayList<>();
        try {
            toDos = this.toDoService.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        model.addAttribute("todos", toDos);
        model.addAttribute("toDo", new ToDo());
        return "list";
    }

    @GetMapping("/create")
    public String create(ToDo toDo) {
        return "create";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute ToDo toDo) {
        try {
            toDo.setCreatedOn();
            this.toDoService.save(toDo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/todo/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        try {
            Optional<ToDo> toDo = this.toDoService.findById(id);
            if (toDo.isPresent()) {
                model.addAttribute("toDo", toDo.get());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute ToDo toDo) {
        try {
            Optional<ToDo> ToDo2= this.toDoService.findById(id);
            if (ToDo2.isPresent()) {
                toDo.setCreatedOn(ToDo2.get().getCreatedOn());
            }
            this.toDoService.save(toDo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/todo/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        try {
            this.toDoService.delete(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/todo/list";
    }

}

