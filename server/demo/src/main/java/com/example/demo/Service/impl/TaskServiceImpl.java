package com.example.demo.Service.impl;

import com.example.demo.Service.TaskService;
import com.example.demo.dto.TaskDto;
import com.example.demo.dto.TodoListDto;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

   public TaskDto CreateTask(TaskDto taskDto) {
     return taskRepository.save(taskDto);
    }

    public List<TaskDto> getAllTask() {
        return taskRepository.findAll();
    }
    public void deleteTask(TaskDto taskDto) {
       taskRepository.delete(taskDto);
    }



}
