package com.example.To_do_list.service;

import com.example.To_do_list.model.ToDo;
import com.example.To_do_list.repository.ToDoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Getter
@Setter
public class ToDoServiceImpl  implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository;


    @Override
    public ToDo createTodo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getTodoById(Long id) {
        return toDoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Todo not found with id:"+id));
    }

    @Override
    public ToDo updateTodo(Long id,ToDo updatedTodo) {
        ToDo existingTodo = getTodoById(id);
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setCompleted(updatedTodo.isCompleted());
        return toDoRepository.save(existingTodo);
    }

    @Override
    public void deleteTodo(Long id) {
         toDoRepository.deleteById(id);
    }
}
