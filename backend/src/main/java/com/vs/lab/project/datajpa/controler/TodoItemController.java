package com.vs.lab.project.datajpa.controler;

import com.vs.lab.project.datajpa.repository.TodoItemRepository;
import com.vs.lab.project.datajpa.model.TodoItem;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/todo")
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;
      /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping
  public List<TodoItem> getAllTodoItems() {
    return todoItemRepository.findAll();
  }

 
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = "application/json", produces = "application/json")
  public TodoItem createTodoItem(@RequestBody TodoItem todoItem){

      todoItem = todoItemRepository.save(todoItem);
      return todoItem;
  }

    @GetMapping("/{name}")
    public Optional<TodoItem> getTodoItemById(@PathVariable String name) {
        Optional<TodoItem> todoItem = todoItemRepository.findById(name);
        return todoItem;
    }
}