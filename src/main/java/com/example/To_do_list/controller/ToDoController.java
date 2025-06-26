package com.example.To_do_list.controller;

import com.example.To_do_list.model.ToDo;
import com.example.To_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    //create a new todos
    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo){
        ToDo savedToDo = toDoService.createTodo(toDo);
        return ResponseEntity.ok(savedToDo);
    }

    //Get all todos
    @GetMapping
    public ResponseEntity<List<ToDo>>getAllToDos(){
        return ResponseEntity.ok(toDoService.getAllTodos());
    }

    //Get todos by id
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id){
        return ResponseEntity.ok(toDoService.getTodoById(id));
    }

    //update a todos
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id,@RequestBody ToDo toDo){
        return ResponseEntity.ok(toDoService.updateTodo(id,toDo));
    }

    //Delete a todos
    @DeleteMapping("/{id}")
    public ResponseEntity<ToDo> deleteToDo(@PathVariable Long id){
        toDoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
