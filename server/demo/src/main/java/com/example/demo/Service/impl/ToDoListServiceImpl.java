package com.example.demo.Service.impl;

import com.example.demo.Service.ToDoListService;
import com.example.demo.dto.TodoListDto;
import com.example.demo.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public TodoListDto CreateToDoList(TodoListDto todoListDto) {

        return toDoListRepository.save(todoListDto);
    }

    public List<TodoListDto> getAllToDoList() {
        return toDoListRepository.findAll();
    }

    public void deleteToDoList(TodoListDto task) {
        toDoListRepository.delete(task);
    }


    }


