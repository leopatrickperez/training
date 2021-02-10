package com.bootcamp.springboot.config;

import com.bootcamp.springboot.services.ToDoService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class beanConfig {
    @Bean
    public ToDoService getTodo() {
        return new ToDoService();
    }
}
