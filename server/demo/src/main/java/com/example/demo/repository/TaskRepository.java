package com.example.demo.repository;

import com.example.demo.dto.TaskDto;
import com.example.demo.dto.TodoListDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskDto, Long> {
}
