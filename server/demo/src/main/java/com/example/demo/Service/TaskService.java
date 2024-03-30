package com.example.demo.Service;

import com.example.demo.dto.TaskDto;
import com.example.demo.dto.TodoListDto;

import java.util.List;

public interface TaskService {

    TaskDto CreateTask(TaskDto taskDto);

    List<TaskDto> getAllTask();
    void deleteTask(TaskDto task);
}
