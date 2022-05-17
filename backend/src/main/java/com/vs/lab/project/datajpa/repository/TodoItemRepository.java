package com.vs.lab.project.datajpa.repository;
import com.vs.lab.project.datajpa.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    
}