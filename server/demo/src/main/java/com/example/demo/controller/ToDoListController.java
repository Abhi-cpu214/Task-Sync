package com.example.demo.controller;

import com.example.demo.Service.ToDoListService;
import com.example.demo.dto.TodoListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/todo")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;


    @GetMapping("/")
    public ResponseEntity<List<TodoListDto>> getAllTasks() {
        return ResponseEntity.ok(toDoListService.getAllToDoList());
    }
    @PostMapping("/")
    public ResponseEntity<TodoListDto> createTask(@RequestBody TodoListDto task) {
        return ResponseEntity.ok(toDoListService.CreateToDoList(task));

    }


}
