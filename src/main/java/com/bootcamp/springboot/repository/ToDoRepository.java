package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.model.ToDo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    @Query(value = "select t from ToDo t where t.name = ?1")
    Optional<ToDo> findByName(String name);

}

