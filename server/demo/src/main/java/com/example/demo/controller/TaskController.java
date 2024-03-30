package com.example.demo.controller;

import com.example.demo.Service.TaskService;
import com.example.demo.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/v1/tasks")
    public class TaskController {

        @Autowired
        private TaskService taskService;


        @GetMapping("/")
        public ResponseEntity<List<TaskDto>> getAllTasks() {
            return ResponseEntity.ok(taskService.getAllTask());
        }
        @PostMapping("/")
        public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task) {
            return ResponseEntity.ok(taskService.CreateTask(task));

        }
    }
