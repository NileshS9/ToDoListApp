package com.example.To_do_list.service;

import com.example.To_do_list.model.ToDo;
import java.util.List;

public interface ToDoService {

    ToDo createTodo(ToDo todo);
    List<ToDo> getAllTodos();
    ToDo getTodoById(Long id);
    ToDo updateTodo(Long id,ToDo todo);
    void deleteTodo(Long id);

}
