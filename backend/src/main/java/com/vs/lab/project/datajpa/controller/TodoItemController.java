package com.vs.lab.project.datajpa.controller;

import com.vs.lab.project.datajpa.repository.TodoItemRepository;
import com.vs.lab.project.datajpa.model.TodoItem;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/todos")
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;
      /**
   * Get all users list.
   *
   * @return the list
   */
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping
  public List<TodoItem> getAllTodoItems() {
    return todoItemRepository.findAll();
  }

 
  @CrossOrigin(origins = "http://localhost:3000")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = "application/json", produces = "application/json")
  public TodoItem createTodoItem(@RequestBody TodoItem todoItem){

      todoItem = todoItemRepository.save(todoItem);
      return todoItem;
  }

     @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{name}")
    public ResponseEntity<Optional<TodoItem>> getTodoItemById(@PathVariable String name) {
        Optional<TodoItem> todoItem = todoItemRepository.findById(name);
        if (todoItem.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todoItem, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{name}")
    public ResponseEntity<Optional<TodoItem>> deleteTodoItem(@PathVariable String name) {

        Optional<TodoItem> todoItem = todoItemRepository.findById(name);
        if (todoItem.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        todoItemRepository.deleteById(name);

        return new ResponseEntity<>(todoItem, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping()
    public ResponseEntity<TodoItem> updateTodoItem(@RequestBody TodoItem todoItemToUpdate) {
        String id = todoItemToUpdate.getTodo();
        if (!todoItemRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        TodoItem todoItem = todoItemRepository.getById(id);
        todoItem.setPriority(todoItemToUpdate.getPriority());
        final TodoItem updatedTodoItem = todoItemRepository.save(todoItem);
        return new ResponseEntity<>(updatedTodoItem, HttpStatus.OK);
    }
}