package com.example.demo.Service;

import com.example.demo.dto.TodoListDto;

import java.util.List;

public interface ToDoListService {

    TodoListDto CreateToDoList(TodoListDto todoListDto);

    List<TodoListDto> getAllToDoList();
     void deleteToDoList(TodoListDto task);
}
